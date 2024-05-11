package com.example.flearns.ui.splash

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flearns.databinding.ActivitySplashBinding
import com.example.flearns.domain.model.ConstantGeneral.Companion.URI_RESOURCE
import com.example.flearns.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_VIDEO = "/" + com.example.flearns.R.raw.flearns

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startVideo()
    }

    private fun startVideo(){

        binding.apply {
            wvSplash.setVideoURI(Uri.parse(URI_RESOURCE + packageName + SPLASH_VIDEO))
            wvSplash.start()
            wvSplash.setOnCompletionListener { startActivity() }
        }
    }

    private fun startActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}