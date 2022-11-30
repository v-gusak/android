package com.lecture9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.lecture9.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        viewModel.currentString.observe(this, Observer {
            binding.tvParity.text = it
        })

        incrementText()

        binding.btnLoad.setOnClickListener {
            lifecycleScope.launch {
                loadData()
            }
        }
    }

    private fun incrementText() {
        binding.btnIncrement.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            if (viewModel.number % 2 == 0) {
                viewModel.currentString.value = "Even"
            } else {
                viewModel.currentString.value = "Odd"
            }
        }
    }

    private suspend fun loadData() {
        binding.tvSusped.text = loadValue()

        Toast.makeText(
            this,
            "Data loaded from suspend",
            Toast.LENGTH_SHORT
        ).show()
    }

    private suspend fun loadValue(): String {
        delay(2000)
        return "Data"
    }
}