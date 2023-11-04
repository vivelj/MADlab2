package com.example.lr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class km21 : AppCompatActivity() {
    lateinit var calcnum1 : EditText
    lateinit var calcnum2 : EditText
    lateinit var calcplus: Button
    lateinit var calcminus: Button
    lateinit var calcumno: Button
    lateinit var calcdele: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_km21)

        calcnum1 = findViewById(R.id.calcnum1)
        calcnum2 = findViewById(R.id.calcnum2)
        calcplus = findViewById(R.id.calcplus)
        calcminus = findViewById(R.id.calcminus)
        calcumno = findViewById(R.id.calcumno)
        calcdele = findViewById(R.id.calcdele)

        calcplus.setOnClickListener {
            val nextpage = Intent(this, km22::class.java)
            nextpage.putExtra("key", plus(calcnum1.text.toString().toInt(), calcnum2.text.toString().toInt()))
            startActivity(nextpage)
            finish()
        }
        calcminus.setOnClickListener {
            val nextpage = Intent(this, km22::class.java)
            nextpage.putExtra("key", minus(calcnum1.text.toString().toInt(), calcnum2.text.toString().toInt()))
            startActivity(nextpage)
            finish()
        }
        calcumno.setOnClickListener {
            val nextpage = Intent(this, km22::class.java)
            nextpage.putExtra("key", umno(calcnum1.text.toString().toInt(), calcnum2.text.toString().toInt()))
            startActivity(nextpage)
            finish()
        }
        calcdele.setOnClickListener {
            val nextpage = Intent(this, km22::class.java)
            nextpage.putExtra("key", dele(calcnum1.text.toString().toInt(), calcnum2.text.toString().toInt()))
            startActivity(nextpage)
            finish()
        }
    }

    fun plus(a: Int, b: Int) : Int {return a + b}
    fun minus(a: Int, b: Int) : Int {return a - b}
    fun umno(a: Int, b: Int) : Int {return a * b}
    fun dele(a: Int, b: Int) : Int {return a / b}
}
