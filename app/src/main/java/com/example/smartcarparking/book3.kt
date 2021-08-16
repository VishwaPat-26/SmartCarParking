package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class book3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book3)
        val book_3_button :Button=findViewById(R.id.button8)
        book_3_button.setOnClickListener {
            startActivity(Intent(this,payment::class.java))
        }
    }
}