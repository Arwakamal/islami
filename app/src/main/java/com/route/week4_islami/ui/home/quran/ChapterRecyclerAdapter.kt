package com.route.week4_islami.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.week4_islami.databinding.ItemChapterTitleBinding
// blocks ,let ,apply ,with ,also
class ChapterRecyclerAdapter(private val chaptersList: List<String>) : RecyclerView.Adapter<ChapterRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(val itemBinding: ItemChapterTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding: ItemChapterTitleBinding =
            ItemChapterTitleBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        return MyViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int = chaptersList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = chaptersList[position]
        holder.bind(title)
       onItemClickListener?.let {listener ->
           holder.itemView.setOnClickListener{
               onItemClickListener?.onItemClick(title ,position)
           }

       }
    }
    var onItemClickListener:OnItemClickListener? =null
   fun interface OnItemClickListener{
        fun onItemClick( title :String ,position: Int)
    }


}