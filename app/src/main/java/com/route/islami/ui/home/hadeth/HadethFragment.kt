package com.route.islami.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.model.Hadeth
import com.route.islami.ui.Constants2
import com.route.islami.ui.hadethDetails.HadethDetailsActivity
import islami.databinding.FragmentHadethBinding

class HadethFragment :Fragment(){

    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater,container,false)
        return  viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }
    fun readHadethFile(){
        val hadethList = mutableListOf<Hadeth>()
        val inputStream =context?.assets?.open("ahadeth.txt")
        val fileContent =inputStream?.bufferedReader().use { it?.readText() }
        val allAhadethList =fileContent?.trim()?.split("#")
        allAhadethList?.forEach { hadeth ->
            val lines = hadeth.trim().split("\n")
            val title = lines[0]
            val completeOneHadethList = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = completeOneHadethList.joinToString("\n")
            val hadethObj = Hadeth(title, content)
            hadethList.add(hadethObj)
        }
        showHadethList(hadethList)
    }

    private fun showHadethList(hadethList: MutableList<Hadeth>) {
        val adapter =HadethRecyclerAdapter(hadethList)
        viewBinding.rvHadeth.adapter = adapter
        adapter.onItemClickListener =
            HadethRecyclerAdapter.OnItemClickListener{ item, postion
                -> startHadethDetailsScreen(item)
        }
    }

    private fun startHadethDetailsScreen(hadeth: Hadeth) {
        val intent =Intent(activity,HadethDetailsActivity::class.java)
        intent.putExtra(Constants2.Hadeth_Extra , hadeth)
        startActivity(intent)

    }


}