package com.example.androidtutorial.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class FirstActivity : AppCompatActivity() {
    lateinit var button1: Button
    private val tag = "kunsang"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val kunsangInt = savedInstanceState?.getInt("kunsang")
        Log.d(tag, "onCreate FirstActivity $kunsangInt")
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            val bundle = Bundle()
            bundle.putString("stringKey", "This is from FirstActivity")
            bundle.putInt("intKey", 20)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart FirstActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume FirstActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause FirstActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop FirstActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy FirstActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart FirstActivity")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("kunsang", 10)
        Log.d(tag, "onSaveInstanceState FirstActivity")
    }
}
