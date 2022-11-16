package com.lecture8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lecture8.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerViewSecond
        val items = createItems()

        itemAdapter = ItemAdapter(this, items)

        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemAdapter.onItemClick = {
            Toast.makeText(this, "You clicked on Item #${it.count}", Toast.LENGTH_LONG).show()
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