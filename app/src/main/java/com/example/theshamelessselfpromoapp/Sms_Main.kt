package com.example.theshamelessselfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.theshamelessselfpromoapp.databinding.ActivitySmsMainBinding
import kotlinx.android.synthetic.main.activity_sms_main.*
import kotlinx.android.synthetic.main.activity_sms_main.button_id
import kotlinx.android.synthetic.main.activity_sms_main.check_box_id
import kotlinx.android.synthetic.main.activity_sms_main.edit_text_my_display_name
import kotlinx.android.synthetic.main.activity_sms_main.edit_text_name
import kotlinx.android.synthetic.main.activity_sms_main.edit_text_number
import kotlinx.android.synthetic.main.activity_sms_main.immediate_start_id
import kotlinx.android.synthetic.main.activity_sms_main.spinner_id
import kotlinx.android.synthetic.main.activity_sms_main.start_date_id

class Sms_Main : AppCompatActivity() {
    lateinit var binding : ActivitySmsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonId.setOnClickListener() {
            onPrevievClicked()
        }
        val spinnerValues : Array<String> = arrayOf("Android Developer", "Android Engineer", "Web Developer", "Systems Analyst", "Cloud Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        binding.spinnerId.adapter = spinnerAdapter
    }


    private fun onPrevievClicked() {
        val message = Message(binding.editTextName.text.toString(),binding.editTextNumber.text.toString(),binding.editTextMyDisplayName.text.toString(), binding.startDateId.text?.toString(), binding.checkBoxId.isChecked, binding.spinnerId.selectedItem?.toString(), binding.immediateStartId.isChecked)
        val PreviewIntent = Intent(this, SmsPreviewActivity::class.java)
        PreviewIntent.putExtra("Message", message)
        startActivity(PreviewIntent)


    }
}