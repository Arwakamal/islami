package com.route.islami.ui.home

import TasbehFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.route.islami.ui.home.hadeth.HadethFragment
import com.route.islami.ui.home.quran.QuranFragment
import com.route.islami.ui.home.radio.RadioFragment
import islami.R
import islami.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.contentMain.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.navigation_quran -> {
                    QuranFragment()
                }

                R.id.navigation_hadeth -> {
                    HadethFragment()
                }

                R.id.navigation_tasbeh -> {
                    TasbehFragment()
                }

                R.id.navigation_Radio -> {
                    RadioFragment()
                }

                else -> {
                    QuranFragment()

                }
            }
            pushFragment(fragment)


            true
        }
        binding.contentMain.bottomNav.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}