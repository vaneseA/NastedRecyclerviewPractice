package com.example.nastedrecyclerviewpractice

import android.view.LayoutInflater
import android.view.ViewGroup
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
            binding.NameArea.text = parentItem.exerciseName
            binding.TypeArea.text = parentItem.exerciseType
            binding.totalSetArea.text = "총 " + parentItem.totalSet.toString() + "set, "
            binding.totalKgArea.text = "총 " + parentItem.totalKG + "kg, "
            binding.bestKgArea.text = "최고 " + parentItem.bestKg + "kg, "
            binding.totalCountArea.text = "총 " + parentItem.totalCount + "회"

            binding.nestedRV.setHasFixedSize(true)
            binding.nestedRV.layoutManager = LinearLayoutManager(itemView.context)
            val adapter = ChildAdapter(parentItem.mList)
            binding.nestedRV.adapter = adapter

        }
    }
}