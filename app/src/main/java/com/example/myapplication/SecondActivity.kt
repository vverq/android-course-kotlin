package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val textView = findViewById<TextView>(R.id.textView2)
        val count = intent.extras?.getInt(MainActivity.COUNT)
            ?.times(intent.extras?.getInt(MainActivity.COUNT)!!)
        textView.text = count.toString()
    }
}