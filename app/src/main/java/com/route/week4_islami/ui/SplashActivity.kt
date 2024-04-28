package com.route.week4_islami.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.route.week4_islami.databinding.ActivitySplashBinding
import com.route.week4_islami.ui.home.MainActivity
import java.util.logging.Handler

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding :ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        android.os.Handler(mainLooper).postDelayed({
            startHomeActivity()
        },2000)
    }
    private fun startHomeActivity() {
        val intent = Intent(this , MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}