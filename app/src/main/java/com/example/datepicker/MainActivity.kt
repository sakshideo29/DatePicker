package com.example.datepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var selectedDate: TextView
    private lateinit var btnDate: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            selectedDate = findViewById(R.id.selectedDate)
            btnDate = findViewById(R.id.btnDate)

            val myCalender=Calendar.getInstance()
            val datePicker = DatePickerDialog.OnDateSetListener{view,year,month,dayofMonth->
                myCalender.set(Calendar.YEAR,year)
                myCalender.set(Calendar.MONTH,month)
                myCalender.set(Calendar.DAY_OF_MONTH,dayofMonth)
                updateLable(myCalender)

            }

            btnDate.setOnClickListener{
                 DatePickerDialog(this,datePicker,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),
                     myCalender.get(Calendar.DAY_OF_MONTH)).show()

                }
        }

    private fun updateLable(myCalender: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        selectedDate.setText(sdf.format(myCalender.time))

    }
}
