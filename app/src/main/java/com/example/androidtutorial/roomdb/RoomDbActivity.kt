package com.example.androidtutorial.roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomDbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_db)
    }
}
