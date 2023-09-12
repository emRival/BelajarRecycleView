package com.rival.belajarrecycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rival.belajarrecycleview.databinding.ItemViewBinding
import com.rival.belajarrecycleview.model.dataHeroes

class heroAdapter(
    val listHero: ArrayList<dataHeroes>) :
    RecyclerView.Adapter<heroAdapter.ListViewHolder>() {

    class ListViewHolder (var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.image)
            .into(holder.binding.imgProfile)

        holder.binding.tvName.text = hero.name

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show()
        }

    }
}