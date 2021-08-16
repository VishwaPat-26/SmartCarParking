package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val getStarted = findViewById<Button>(R.id.button)
        getStarted.setOnClickListener {
            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}