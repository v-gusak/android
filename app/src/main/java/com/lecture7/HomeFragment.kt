package com.lecture7

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lecture7.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.setFragmentResultListener("main_data", this) { _, bundle ->
            val message = bundle.getString("data")
            binding.homeDataContainer.text = message
        }

        binding.sendDataFromHomeFragmentToSecond.setOnClickListener {
            val message = binding.homeDataContainer.text.toString()

            if(message.isNotEmpty()) {
                val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment(message)
                findNavController().navigate(action)
            }
        }
    }
}