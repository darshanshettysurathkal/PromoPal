package com.example.theshamelessselfpromoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.theshamelessselfpromoapp.databinding.ActivityEmailPreviewBinding

class EmailPreviewActivity : AppCompatActivity() {
    private lateinit var message: MessageEmail
    private lateinit var messagePreviewText: String
    lateinit var binding: ActivityEmailPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MessageDisplay()
        sendbutton()
    }


    private fun MessageDisplay() {
        message = intent.getSerializableExtra("Message") as MessageEmail
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


    private fun sendbutton() {
        binding.sendMessageButtonId.setOnClickListener {
            val emailadd = listOf(message.contactEmail)
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${emailadd.joinToString(",")}")
                putExtra(Intent.EXTRA_SUBJECT, "Requesting for Internship opportunity")
                putExtra(Intent.EXTRA_TEXT, messagePreviewText)
            }
            startActivity(intent)
        }
    }
}