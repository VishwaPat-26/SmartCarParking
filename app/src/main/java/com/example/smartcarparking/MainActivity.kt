package com.example.smartcarparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.smartcarparking.R.id.*


import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val iv_click_me = findViewById(R.id.imageView4) as ImageView
        // set on-click listener
        iv_click_me.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            val intent = Intent(this,siliconparking::class.java)
            startActivity(intent)
        }
        val iv_check_status = findViewById(R.id.imageViewS) as ImageView
        // set on-click listener
        iv_check_status.setOnClickListener {
            // your code to perform when the user clicks on the ImageView

            startActivity(Intent(this,Status1::class.java))
        }
        val contact_us=findViewById(R.id.imageView6) as ImageView
        contact_us.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
        val book_main=findViewById(R.id.imageViewB) as ImageView
        book_main.setOnClickListener {
            startActivity(Intent(this,Book1::class.java))
        }



    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_my_profile -> run {
                Toast.makeText(this, " MY PROFILE NOT YET COMPLETED", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sign_out -> {
                startActivity(Intent(this,intro::class.java))
            }

        }
        return true

    }




}