package com.route.week4_islami.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.week4_islami.databinding.FragmentHadethBinding
import com.route.week4_islami.model.Hadeth
import com.route.week4_islami.ui.Constants2
import com.route.week4_islami.ui.hadethDetails.HadethDetailsActivity

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
        // open take file name
        val inputStream =context?.assets?.open("ahadeth.txt")
        val fileContent =inputStream?.bufferedReader().use { it?.readText() }
        val allAhadethList =fileContent?.trim()?.split("#")
        allAhadethList?.forEach { hadeth ->
            // hadethTitle + hadethContent
            val lines = hadeth.trim().split("\n")
            val title = lines[0]
            // (content) complete hadeth without title  line by line in list
            val completeOneHadethList = lines.toMutableList().apply {
                removeAt(0)
            }
            // (content) complete hadeth without title  as String
            val content = completeOneHadethList.joinToString("\n")
            val hadethObj = Hadeth(title, content)
            // list of ahadeth objects every hadeth have title and content()
            hadethList.add(hadethObj)
        }
        showHadethList(hadethList)
    }

    private fun showHadethList(hadethList: MutableList<Hadeth>) {
        // show tiltle of hadeth in Hadeth Rcycler View
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