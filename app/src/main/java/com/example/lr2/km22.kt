package com.example.lr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class km22 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_km22)

        val receivedValue = intent.getIntExtra("key", 0)
        val textView = findViewById<TextView>(R.id.resultTextView)
        textView.text = receivedValue.toString()
    }
}