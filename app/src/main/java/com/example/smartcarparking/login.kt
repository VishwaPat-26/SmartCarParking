package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_login)
        val showButton = findViewById<Button>(R.id.button2)
        showButton.setOnClickListener {
            signin()
        }
        var nextsign =findViewById<TextView>(R.id.textView5)
        nextsign.setOnClickListener {
            val intent=Intent(this,signup::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun signin() {
        var id1 =findViewById<EditText>(R.id.editTextTextEmailAddress)
        var password1=findViewById<EditText>(R.id.editTextTextPassword)
        var id = id1.text.toString()
        var password = password1.text.toString()
        if(id.isBlank()||password.isBlank()){
            Toast.makeText(this, "Id and Password fields are blank", Toast.LENGTH_SHORT).show()
        }
        //firebaseAuth.signInWithEmailAndPassword(id,password).addOnCompleteListener {
          //  if (it.isSuccessful) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
        //    } else {
          //      Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
           // }
       // }

    }
}