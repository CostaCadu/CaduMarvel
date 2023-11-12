package com.example.marvelcadu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcadu.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}