package com.example.androidtutorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var button1: Button
    lateinit var editText1: EditText
    lateinit var switch1: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = findViewById(R.id.textView1)
        button1 = findViewById(R.id.button1)
        editText1 = findViewById(R.id.editText1)
        switch1 = findViewById(R.id.switch1)
        button1.setOnClickListener {
            val text = editText1.text
            textView1.text = text
        }
        button1.setOnLongClickListener {
            (it as Button).text = "LongClicked"
            true
        }
        /* editText1.addTextChangedListener(object : TextWatcher {
             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
             }

             override fun onTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
             }

             override fun afterTextChanged(p0: Editable?) {
             }
         })*/

        editText1.addTextChangedListener {
            val length = editText1.length()
            val text = "Word count = $length"
            textView1.text = text
        }
        switch1.setOnCheckedChangeListener { _, b ->
            if (b) {
                textView1.visibility = View.VISIBLE
            } else {
                textView1.visibility = View.GONE
            }
        }
    }
}
