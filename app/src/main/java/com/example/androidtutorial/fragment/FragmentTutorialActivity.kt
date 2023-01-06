package com.example.androidtutorial.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentTutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_tutorial)
    }
}
