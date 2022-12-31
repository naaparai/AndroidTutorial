package com.example.androidtutorial.container

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.androidtutorial.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class ScrollBasedActivity : AppCompatActivity() {
    // lateinit var toolbar: Toolbar
    // lateinit var toolbarLayout: CollapsingToolbarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_based)
        // setSupportActionBar(toolbar)
        // toolbar = findViewById(R.id.toolbar)
        // setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        // toolbarLayout = findViewById(R.id.toolbar_layout)
        // toolbarLayout.title = title

    }
}