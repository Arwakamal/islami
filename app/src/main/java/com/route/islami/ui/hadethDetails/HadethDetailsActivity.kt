package com.route.islami.ui.hadethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.route.islami.model.Hadeth
import com.route.islami.ui.Constants2
import islami.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityHadethDetailsBinding
    var hadethObj: Hadeth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        extractParams()
        initViews()


    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolBar)
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewBinding.titleTv.text = hadethObj?.title
        viewBinding.contentHadeth.hadethContent.text = hadethObj?.content

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun extractParams() {
        hadethObj = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants2.Hadeth_Extra, Hadeth::class.java)
        } else {
            intent.getParcelableExtra<Hadeth>(Constants2.Hadeth_Extra) as Hadeth
        }
    }
}