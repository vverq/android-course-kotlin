package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        const val COUNT = "COUNT"
        const val MAIN_ACTIVITY = "MAIN_ACTIVITY"
    }

    private lateinit var textView: TextView
    private var count = 0
        set(value) {
            field = value
            findViewById<TextView>(R.id.textView1).text = value.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(MAIN_ACTIVITY, "onCreate: $count")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView1)
        textView.text = "0"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(MAIN_ACTIVITY, "onSaveInstanceState: $count")
        outState.putInt(COUNT, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(MAIN_ACTIVITY, "onRestoreInstanceState: $count")
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(COUNT)+1
        textView.text = count.toString()
    }

    fun sendMessage(view: View?) {
        Log.i(MAIN_ACTIVITY, "sendMessage: $count")
        val intent = Intent(this, SecondActivity::class.java).apply{
            val bundle = Bundle().apply{putInt(COUNT, count)}
            putExtras(bundle)
        }
        startActivity(intent)
    }
}