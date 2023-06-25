package com.example.theshamelessselfpromoapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resume : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etExperience: EditText
    private lateinit var btnGenerate: Button
    private lateinit var tvResume: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etExperience = findViewById(R.id.etExperience)
        btnGenerate = findViewById(R.id.btnGenerate)
        tvResume = findViewById(R.id.tvResume)

        btnGenerate.setOnClickListener {
            generateResume()
        }
    }

    private fun generateResume() {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val experience = etExperience.text.toString().trim()

        val resume = "Name: $name\nEmail: $email\nExperience: $experience"
        tvResume.text = resume
        tvResume.visibility = View.VISIBLE
    }
}
