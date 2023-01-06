package com.example.androidtutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.androidtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val someObject = SomeObject("this is from object", "", false)
        val otherObject = OtherObject("this is from object")
        binding.someObject = someObject
        binding.button1.setOnClickListener {
            val text = "${someObject.passwordText} ${someObject.switchBoolean}"
            binding.textView1.text = text
        }
        binding.button1.setOnLongClickListener {
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

        binding.editText1.addTextChangedListener {
            val length = binding.editText1.length()
            val text = "Word count = $length"
            binding.textView1.text = text
        }
        binding.switch1.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.textView1.visibility = View.VISIBLE
            } else {
                binding.textView1.visibility = View.GONE
            }
        }
        binding.buttonTutorial.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }
    }
}

data class SomeObject(val someString: String, var passwordText: String, var switchBoolean: Boolean)
data class OtherObject(val someString: String)
