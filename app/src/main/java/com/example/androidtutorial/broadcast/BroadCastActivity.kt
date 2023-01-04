package com.example.androidtutorial.broadcast

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class BroadCastActivity : AppCompatActivity() {
    lateinit var textViewBTStatus: TextView
    val mBroadcastReceiver1 = MyBroadCast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast)
        textViewBTStatus = findViewById(R.id.textViewBluetooth)
        val filter1 = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(mBroadcastReceiver1, filter1)
        // some comment
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mBroadcastReceiver1)
    }

    inner class MyBroadCast : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                when (intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)) {
                    BluetoothAdapter.STATE_OFF -> {
                        textViewBTStatus.text = "Blueooth is Off"
                    }
                    BluetoothAdapter.STATE_ON -> {
                        textViewBTStatus.text = "Blueooth is On"
                    }
                }
            }
        }
    }
}
