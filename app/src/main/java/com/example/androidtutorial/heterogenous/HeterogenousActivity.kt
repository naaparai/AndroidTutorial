package com.example.androidtutorial.heterogenous

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeterogenousActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heterogenous)
    }
}
