package com.example.theshamelessselfpromoapp

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.theshamelessselfpromoapp.databinding.ActivityEmailMainBinding

class EmailMain : AppCompatActivity() {
    lateinit var binding: ActivityEmailMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinnerValues : Array<String> = arrayOf("Android Developer", "Android Engineer", "Web Developer", "Systems Analyst", "Cloud Engineer")
        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item,spinnerValues)
        binding.spinnerId.adapter = spinnerAdapter

        binding.buttonId.setOnClickListener {
            onPreviewButtonClicked()
        }


    }

    private fun onPreviewButtonClicked() {
        val message = MessageEmail(binding.editTextName.text.toString(),binding.editTextEmail.text.toString(),binding.editTextMyDisplayName.text.toString(), binding.startDateId.text?.toString(), binding.checkBoxId.isChecked, binding.spinnerId.selectedItem?.toString(), binding.immediateStartId.isChecked)
        val PreviewIntent = Intent(this, EmailPreviewActivity::class.java)
        PreviewIntent.putExtra("Message", message)
        startActivity(PreviewIntent)
    }

}