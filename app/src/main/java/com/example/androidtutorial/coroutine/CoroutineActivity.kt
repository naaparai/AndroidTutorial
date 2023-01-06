package com.example.androidtutorial.coroutine

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidtutorial.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class CoroutineActivity : AppCompatActivity() {
    lateinit var tvWithoutCoroutine: TextView
    lateinit var tvWithCoroutine: TextView
    lateinit var tvnormalCall: TextView
    lateinit var tvSuspendCancelable: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        tvWithoutCoroutine = findViewById(R.id.tvWithoutCoroutineTimer)
        tvWithCoroutine = findViewById(R.id.tvWithCoroutineTimer)
        tvnormalCall = findViewById(R.id.tvNormalCall)
        tvSuspendCancelable = findViewById(R.id.tvSuspendCancellable)
        timer1 { one, two ->
            val myString = "$one $two"
            tvnormalCall.text = myString
        }
        timer2()
        //
        lifecycleScope.launch {
            val myString1 = timer3().first
            tvSuspendCancelable.text = myString1
        }
    }

    fun timer1(callback: (String, Int) -> Unit) {
        val timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timerText = ((20000 - millisUntilFinished) / 1000).toString()
                tvWithoutCoroutine.text = timerText
                Log.d("Kunsang without", timerText)
            }

            override fun onFinish() {
                callback("TickerFinished", 1)
            }
        }
        timer.start()
    }

    fun timer2() {
        lifecycleScope.launch {
            for (i in 0..20) {
                tvWithCoroutine.text = i.toString()
                delay(1000L)
                Log.d("Kunsang with", i.toString())
            }
        }
    }

    suspend fun timer3(): Pair<String, Int> {
        return suspendCancellableCoroutine { continuation ->
            val timer = object : CountDownTimer(20000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    continuation.resume(Pair("This is from onFinish", 1))
                }
            }
            timer.start()
        }
    }
}
