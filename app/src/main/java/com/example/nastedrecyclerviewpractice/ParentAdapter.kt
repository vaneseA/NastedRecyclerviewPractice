package com.example.nastedrecyclerviewpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nastedrecyclerviewpractice.databinding.ParentItemBinding

class ParentAdapter(
    private val parentList: List<ParentItem>
) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val binding =
            ParentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = parentList[position]
        holder.setData(parentItem, position)
    }

    override fun getItemCount(): Int = parentList.size

    inner class ParentViewHolder(val binding: ParentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(parentItem: ParentItem, position: Int) {
            binding.parentLogoIv.setImageResource(parentItem.logo)
            binding.parentTitleTv.text = parentItem.title


            binding.nestedRV.setHasFixedSize(true)
            binding.nestedRV.layoutManager = LinearLayoutManager(itemView.context)
            val adapter = ChildAdapter(parentItem.mList)
            binding.nestedRV.adapter = adapter

        }
    }
}