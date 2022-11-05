package com.lecture6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lecture6.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            val intentUserData = intent.getParcelableExtra<UserData>("userData")
            val intentForTest = intent.getIntExtra("forTest", 0)

            intentUserData?.let {
                if(intentForTest != 0) {
                    binding.textView2.text = "${it.name} | ${it.age} | ${it.isStudent} | test Int = ${intentForTest}"
                }
            }
        }

        binding.button6.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.button7.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lecture6", "onDestroy Call")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("lecture6", "onSaveInstanceState Call")

        outState.apply {
            putString("userData", binding.textView2.text.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d("lecture6", "onRestoreInstanceState Call")

        savedInstanceState.run {
            binding.textView2.text = getString("userData")
        }
    }
}