package com.lecture8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var onItemClick : ((Item) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
            itemView.findViewById<TextView>(R.id.tvName).text = item.name
            itemView.findViewById<TextView>(R.id.tvAge).text = "Count: ${item.count}"

            val ivPicture = itemView.findViewById<ImageView>(R.id.ivPicture)
            Glide.with(context).load(item.imageUrl).into(ivPicture)

            val ivSecondPicture = itemView.findViewById<ImageView>(R.id.ivSecondPicture)
            Glide.with(context).load(item.imageUrlSecond).into(ivSecondPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bind(item)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}