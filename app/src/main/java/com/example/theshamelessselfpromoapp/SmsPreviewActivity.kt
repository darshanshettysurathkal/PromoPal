package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.theshamelessselfpromoapp.databinding.ActivitySmsPreviewBinding
import kotlinx.android.synthetic.main.activity_sms_preview.*
import kotlinx.android.synthetic.main.activity_sms_preview.send_message_button_id
import kotlinx.android.synthetic.main.activity_sms_preview.text_view_id

class SmsPreviewActivity : AppCompatActivity() {
    lateinit var binding: ActivitySmsPreviewBinding
    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MessageDisplay()
        SetButton()

    }

    private fun MessageDisplay() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hello ${message.contactName}
                
                My name is ${message.MyDisplayName} and i am ${message.getfulldesc()}.
                
                I Have a Portfolio of apps to show for my work.
                
                i am able to start new position ${message.availability()}.
                
                Please get in touch if there is Suitable role for me.
                
                Thank you and best Regard.
                
            """.trimIndent()


        binding.textViewId.text = messagePreviewText
    }

    fun SetButton() {

        binding.sendMessageButtonId.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")  // This ensures only SMS apps respond
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }

    }
}

