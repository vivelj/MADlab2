package com.example.lr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn : Button = findViewById(R.id.upr1)
        val btn2 : Button = findViewById(R.id.upr2)

        btn.setOnClickListener {
            val nextpage = Intent(this, upra1::class.java)
            startActivity(nextpage)
            finish()
        }
        btn2.setOnClickListener {
            val nextpage = Intent(this, upra2::class.java)
            startActivity(nextpage)
            finish()
        }
    }
}