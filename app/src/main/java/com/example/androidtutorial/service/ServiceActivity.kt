package com.example.androidtutorial.service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class ServiceActivity : AppCompatActivity() {
    lateinit var buttonStart: Button
    lateinit var buttonStop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
        val intent = Intent(this, MusicService::class.java)
        buttonStart.setOnClickListener {
            startService(intent)
        }
        buttonStop.setOnClickListener {
            stopService(intent)
        }
    }
}
