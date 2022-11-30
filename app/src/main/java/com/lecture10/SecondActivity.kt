package com.lecture10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lecture10.databinding.ActivitySecondBinding
import io.realm.Realm
import io.realm.RealmConfiguration

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder().allowWritesOnUiThread(true).build()
        realm = Realm.getInstance(realmConfiguration)

        binding.btnSavePersonal.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString()

            if(name.isNotEmpty() && age.isNotEmpty()) {
                val user = RealmUser(name = name, age = age.toInt())

                realm.executeTransaction { realm -> realm.copyToRealm(user) }

                Toast.makeText(
                    applicationContext,
                    "Personal data saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnReadPersonal.setOnClickListener {
            val userData: List<RealmUser> = realm.where(RealmUser::class.java).findAll()
            var userInfo = ""

            if(userData.isNotEmpty()) {
                userData.forEach {
                    userInfo += "${it.name} ${it.age} ${it.id}\n\n"
                }
            }

            binding.tvOutputPersonal.text = userInfo

            Toast.makeText(
                applicationContext,
                "Data from the DB has been read",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}