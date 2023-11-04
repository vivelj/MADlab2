package com.example.lr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var textInput: EditText
    lateinit var textInput2: EditText
    lateinit var textInput3: EditText
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput = findViewById(R.id.ka)
        textInput2 = findViewById(R.id.kb)
        textInput3 = findViewById(R.id.kc)
        result = findViewById(R.id.textView2)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            val result1 = findQuadraticSolution(textInput.text.toString().toDouble(), textInput2.text.toString().toDouble(), textInput3.text.toString().toDouble())
            result.setText(result1)
        }
        val btn2: Button = findViewById(R.id.zadanie2)

        btn2.setOnClickListener {
            val nextpage = Intent(this, SecondActivity::class.java)
            startActivity(nextpage)
            finish()
        }

        val btn3: Button = findViewById(R.id.km2)
        btn3.setOnClickListener {
            val nextpage = Intent(this, km21::class.java)
            startActivity(nextpage)
            finish()
        }

    }

    fun findQuadraticSolution(a: Double, b: Double, c: Double) : String{
        // Вычисляем дискриминант
        val discriminant = b * b - 4 * a * c

        // Если дискриминант больше или равен нулю, есть действительные корни
        if (discriminant >= 0) {
            // Вычисляем корни
            val x1 = (-b + sqrt(discriminant)) / (2 * a)
            val x2 = (-b - sqrt(discriminant)) / (2 * a)
            return ("Решение $x1 $x2")
        } else {
            return ("Нет решения")
        }
    }

}