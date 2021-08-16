package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class signup : AppCompatActivity() {
    lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
        firebaseAuth = FirebaseAuth.getInstance()
        val showButton = findViewById<Button>(R.id.button3)
        showButton.setOnClickListener {
            userSignUp()
        }
        var nextsign2 =findViewById<TextView>(R.id.textView6)
        nextsign2.setOnClickListener {
            val intent= Intent(this,login::class.java)
            startActivity(intent)
            finish()
        }
    }

    public fun userSignUp() {
        val id = findViewById<EditText>(R.id.etId)
        val pass1 = findViewById<EditText>(R.id.etPassword)
        val pass2 = findViewById<EditText>(R.id.etConfirmPassword)
        val email =id.text.toString()
        val password =pass1.text.toString()
        val confirmPassword=pass2.text.toString()
        if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
            Toast.makeText(this,"Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if(password!=confirmPassword)
        {
            Toast.makeText(this,"Password and Confirm Password doesn't match", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Toast.makeText(this,"USER SUCESSFULLY CREATED", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()

                
            }
            else
            {
                Toast.makeText(this,"ERROR CREATING USER", Toast.LENGTH_SHORT).show()
            }
        }
    }
}