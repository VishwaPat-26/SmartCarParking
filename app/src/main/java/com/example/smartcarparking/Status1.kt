package com.example.smartcarparking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class Status1 : AppCompatActivity() {
    lateinit var barlist:ArrayList<BarEntry>

    lateinit var BarDataSet:BarDataSet
    lateinit var barData:BarData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_status1)
        val status_1_button : Button =findViewById(R.id.button7)
        status_1_button.setOnClickListener {
            Toast.makeText(this,"Cancel activity not yet created", Toast.LENGTH_LONG).show()
        }
        barlist= ArrayList()
        barlist.add(BarEntry(1f,500f))
        barlist.add(BarEntry(2f,200f))
        barlist.add(BarEntry(3f,400f))
        barlist.add(BarEntry(4f,100f))
        BarDataSet= BarDataSet(barlist,"Parking")
        barData= BarData(BarDataSet)
        var barChart:BarChart=findViewById(R.id.bc)
        barChart.data=barData
        BarDataSet.setColors(ColorTemplate.JOYFUL_COLORS,250)

        BarDataSet.valueTextColor= Color.BLACK
        BarDataSet.valueTextColor=Color.BLUE
    }
}