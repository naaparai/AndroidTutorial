package com.example.androidtutorial.container

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class CoordinatorLayoutActivity : AppCompatActivity() {
    lateinit var btnLayoutBased: Button
    lateinit var btnScrollBased: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        btnLayoutBased = findViewById(R.id.btnLayoutBased)
        btnScrollBased = findViewById(R.id.btnScrollBased)

        btnLayoutBased.setOnClickListener {
            val intent = Intent(this, LayoutBasedActivity::class.java)
            startActivity(intent)
        }

        btnScrollBased.setOnClickListener {
            val intent = Intent(this, ScrollBasedActivity::class.java)
            startActivity(intent)
        }
    }
}
