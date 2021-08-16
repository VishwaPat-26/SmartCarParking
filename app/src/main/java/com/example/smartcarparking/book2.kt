package com.example.smartcarparking

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.*
import org.w3c.dom.Text
import java.util.*

class book2 : AppCompatActivity() {
    lateinit var option:Spinner

    lateinit var option2:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book2)
        option=findViewById(R.id.spin) as Spinner


        val options= arrayOf("Scooty","Bike","Car")
        option.adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)


        val buttonEntry:Button=findViewById(R.id.button4) as Button
        val buttonExit:Button=findViewById(R.id.button5) as Button
        buttonEntry.setOnClickListener { view->
            clickDatePicker1(view)
        }
        buttonExit.setOnClickListener { view->
            clickDatePicker2(view)
        }
        val nextButton:Button=findViewById(R.id.button6) as Button
        nextButton.setOnClickListener {
            startActivity(Intent(this,book3::class.java))
        }
    }
    fun clickDatePicker1(view: View){

        val myCal =Calendar.getInstance()
        val year =myCal.get(Calendar.YEAR)
        val month =myCal.get(Calendar.MONTH)
        val tv1 :TextView=findViewById(R.id.textView19) as TextView
        val day =myCal.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
            view, year, month, dayOfMonth ->

        },year,month,day).show()

        val selectedDate1 ="$day/${month+1}/$year"
        tv1.setText(selectedDate1)


    }
    fun clickDatePicker2(view: View){

        val myCal2 =Calendar.getInstance()
        val year2 =myCal2.get(Calendar.YEAR)
        val month2 =myCal2.get(Calendar.MONTH)
        val tv2 :TextView=findViewById(R.id.textView25) as TextView
        val day2 =myCal2.get(Calendar.DAY_OF_MONTH)



        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
            view, year, month, dayOfMonth ->

        },year2,month2,day2).show()

        val selectedDate2 ="$day2/${month2+1}/$year2"
        tv2.setText(selectedDate2)


    }
}