package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.theshamelessselfpromoapp.databinding.ActivitySplashScreenBinding

class Splash_Screen : AppCompatActivity() {
  lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setfonts()
        setanims()
        Handler().postDelayed({
           val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()    //if not given user will come back to spalsh screen
        }, 5000)


    }

    private fun setanims() {
        val topanim: Animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val botanim: Animation = AnimationUtils.loadAnimation(this,R.anim.bottoom_animation)
        binding.logoId.animation =topanim
        binding.infoId.animation =botanim
    }

    private fun setfonts() {
        val tf: Typeface = Typeface.createFromAsset(assets, "fonts/Lobster-Regular.ttf")
        binding.infoId.typeface = tf
    }

}