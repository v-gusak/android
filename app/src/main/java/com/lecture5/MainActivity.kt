package com.lecture5

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.lecture5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                binding.textView.text = binding.editText.text
            }
        })

        binding.buttonHide.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                binding.textView.isVisible = false
            }
        })

        binding.buttonShow.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                binding.textView.isVisible = true
            }
        })

        binding.editText.addTextChangedListener { binding.textView.text = getString(R.string.addTextChanged_text) }
    }
}