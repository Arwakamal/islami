package com.route.islami.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.route.islami.ui.home.MainActivity
import islami.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivitySplashBinding
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