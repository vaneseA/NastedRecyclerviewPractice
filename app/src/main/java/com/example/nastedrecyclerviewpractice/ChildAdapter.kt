package com.example.nastedrecyclerviewpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nastedrecyclerviewpractice.databinding.ChildItemBinding

class ChildAdapter(private val childList: List<ChildItem>) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding = ChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val childItem = childList[position]
        holder.recordData(childItem, position)
    }

    override fun getItemCount(): Int = childList.size


    inner class ChildViewHolder(val binding: ChildItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun recordData(childItem: ChildItem, position: Int) {
            binding.childTitleTv.text = childList[position].title
            binding.childLogoIv.setImageResource(childList[position].logo)
        }
    }
}




