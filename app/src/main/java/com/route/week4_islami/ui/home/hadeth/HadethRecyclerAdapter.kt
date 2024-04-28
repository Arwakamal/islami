package com.route.week4_islami.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.week4_islami.databinding.ItemChapterTitleBinding
import com.route.week4_islami.databinding.ItemHadethTitleBinding
import com.route.week4_islami.model.Hadeth

// blocks ,let ,apply ,with ,also
class HadethRecyclerAdapter(private val ahadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemViewBinding: ItemHadethTitleBinding =
            ItemHadethTitleBinding
                .inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
        return MyViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int = ahadethList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hadeth = ahadethList[position]
        holder.bind(hadeth.title)
       onItemClickListener?.let {listener ->
           holder.itemView.setOnClickListener{
               onItemClickListener?.onItemClick(hadeth ,position)
           }

       }
    }
    var onItemClickListener:OnItemClickListener? =null
   fun interface OnItemClickListener{
        fun onItemClick(item :Hadeth ,position: Int)
    }

    class MyViewHolder(val itemBinding: ItemHadethTitleBinding) : RecyclerView.ViewHolder(
        itemBinding.root
    ) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }
}