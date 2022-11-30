package com.lecture10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.lecture10.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Shared Preferences
        binding.btnSave.setOnClickListener {
            val sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putInt(getString(R.string.seekBar_progress),
                    binding.seekBar.progress)
                apply()

                Toast.makeText(
                    applicationContext,
                    "Settings saved to preferences",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.btnRead.setOnClickListener {
            val sharedPref = getSharedPreferences(getString(R.string.preference_file_key),
            MODE_PRIVATE) ?: return@setOnClickListener

            val seekBarField = sharedPref.getInt(getString(R.string.seekBar_progress), 0)

            binding.tvOutput.text = "Seek Bar current progress: $seekBarField"

            Toast.makeText(
                applicationContext,
                "Settings have been read from preferences",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Room
        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java, "database-name"
        ).build()

        val userDao = db.userDao()

        binding.btnSavePersonal.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString()

            if(name.isNotEmpty() && age.isNotEmpty()) {

                val user = User(name = name, age = age.toInt())

                lifecycleScope.launch(Dispatchers.IO) {
                    userDao.insertAll(user)
                }

                Toast.makeText(
                    applicationContext,
                    "Personal data saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnReadPersonal.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val users = userDao.getAll()
                var usersInfo = ""

                users.forEach {
                    usersInfo += "Name: ${it.name} Age: ${it.age}\n"
                }

                runOnUiThread {
                    binding.tvOutputPersonal.text = usersInfo
                }
            }

            Toast.makeText(
                applicationContext,
                "Data from the DB has been read",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnDeletePersonal.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                userDao.deleteAll()
            }

            Toast.makeText(
                applicationContext,
                "Database was cleared",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnRealm.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}