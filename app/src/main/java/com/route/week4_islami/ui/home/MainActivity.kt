package com.route.week4_islami.ui.home

import TasbehFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.route.week4_islami.R
import com.route.week4_islami.databinding.ActivityMainBinding
import com.route.week4_islami.ui.home.hadeth.HadethFragment
import com.route.week4_islami.ui.home.quran.QuranFragment
import com.route.week4_islami.ui.home.radio.RadioFragment


// host activity -> activity carry fragment in it
// every activity have object from fragment manager

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

            // item is selected
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