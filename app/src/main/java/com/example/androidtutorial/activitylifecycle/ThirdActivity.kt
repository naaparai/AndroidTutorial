package com.example.androidtutorial.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class ThirdActivity : AppCompatActivity() {
    private val tag = "kunsang"
    lateinit var textView1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        textView1 = findViewById(R.id.textView1)
        val bundle = intent.extras
        val myString = bundle?.getString("stringKey")
        val myInt = bundle?.getInt("intKey")
        Log.d(tag, "onCreate ThirdActivity")
        textView1.text = "$myString $myInt"
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart ThirdActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume ThirdActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause ThirdActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop ThirdActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy ThirdActivity")
    }
}
