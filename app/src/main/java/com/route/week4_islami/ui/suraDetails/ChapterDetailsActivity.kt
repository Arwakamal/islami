package com.route.week4_islami.ui.suraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.week4_islami.databinding.ActivityChapterDetailsBinding
import com.route.week4_islami.ui.Constants

class ChapterDetailsActivity :AppCompatActivity(){
    lateinit var viewBinding: ActivityChapterDetailsBinding
     var chapterIndex :Int =0
    lateinit var chapterTitle:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)
        chapterIndex =intent.getIntExtra(Constants.CHAPTER_INDEX,0)
        chapterTitle =intent.getStringExtra(Constants.CHAPTER_TITLE)?:""
        initViews()
        readSurahFile()
    }
    private fun initViews() {
        viewBinding.titleTv.text= chapterTitle
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun readSurahFile() {
       val inputStream = assets.open("$chapterIndex.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val linesList =fileContent.trim().split("\n")
        initRecyclerView(linesList)
    }

    private fun initRecyclerView(verses:List<String>) {
        val adapter =VersesRecyclerAdapter(verses)
        viewBinding.contentChapter.rvChapterDetails.adapter = adapter
    }




}