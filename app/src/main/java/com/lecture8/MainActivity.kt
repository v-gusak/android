package com.lecture8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lecture8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val items = createItems()

        itemAdapter = ItemAdapter(this, items)

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        itemAdapter.onItemClick = {
            Toast.makeText(this, "You clicked on Item #${it.count}", Toast.LENGTH_LONG).show()
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun createItems(): List<Item> {
        val items = mutableListOf<Item>()

        for (i in 1..25) {
            items.add(Item("Item #$i", i))
        }

        return items
    }
}