package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Book1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)
        val BookBut:Button=findViewById(R.id.BookButton)
        BookBut.setOnClickListener {
            startActivity(Intent(this,book2::class.java))
        }
    }
}