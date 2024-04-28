package com.route.islami.ui.suraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import islami.databinding.ItemVerseBinding

class VersesRecyclerAdapter (private val versesList: List<String>) : RecyclerView.Adapter<VersesRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(val itemViewBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(verse: String) {
            itemViewBinding.verse.text = verse
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val verse =versesList.get(position)
        holder.bind(verse)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemViewBinding :ItemVerseBinding = ItemVerseBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
       return MyViewHolder(itemViewBinding)
    }


    override fun getItemCount(): Int = versesList.size



}