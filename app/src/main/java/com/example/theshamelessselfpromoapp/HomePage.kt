package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.theshamelessselfpromoapp.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setfonts()
        seOnClickListners()
    }

    private fun seOnClickListners() {
        binding.smsCardViewId.setOnClickListener {
            val intent = Intent(this, Sms_Main::class.java)
            startActivity(intent)
        }

        binding.emailCardViewId.setOnClickListener {
            val intent = Intent(this, EmailMain::class.java)
            startActivity(intent)
        }
    }

    private fun setfonts() {
       val tf: Typeface = Typeface.createFromAsset(assets, "fonts/Quicksand-VariableFont_wght.ttf")
        binding.smsCardHeading.typeface =tf
        binding.emailCardHeading.typeface= tf

    }
}