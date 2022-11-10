package com.lecture7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.lecture7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        binding.sendDataToHomeFragment.setOnClickListener {
            val data = binding.messageContainer.text.toString()

            if (data.isNotEmpty()) {

                navHostFragment.childFragmentManager.fragments[0].childFragmentManager
                    .setFragmentResult(
                        "main_data",
                        bundleOf("data" to data)
                    )

                binding.messageContainer.isEnabled = false
                binding.sendDataToHomeFragment.isEnabled = false
                binding.fragmentContainerView.findViewById<Button>(R.id.sendDataFromHomeFragmentToSecond).isEnabled = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        binding.messageContainer.isEnabled = true
        binding.sendDataToHomeFragment.isEnabled = true

        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
}