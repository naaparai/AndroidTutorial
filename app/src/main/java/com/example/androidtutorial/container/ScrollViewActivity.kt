package com.example.androidtutorial.container

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.example.androidtutorial.R

class ScrollViewActivity : AppCompatActivity() {
    lateinit var nestedScrollview: NestedScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)
        nestedScrollview = findViewById(R.id.nestedScrollview)
        nestedScrollview.isNestedScrollingEnabled = true
    }
}
