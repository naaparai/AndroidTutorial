package com.example.androidtutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.activitylifecycle.FirstActivity
import com.example.androidtutorial.container.ConstraintActivity
import com.example.androidtutorial.container.LinearLayoutActivity
import com.example.androidtutorial.container.RelativeLayoutActivity
import com.example.androidtutorial.container.ScrollViewActivity
import com.example.androidtutorial.fragment.FragmentTutorialActivity
import com.example.androidtutorial.service.ServiceActivity

class TutorialActivity : AppCompatActivity() {
    lateinit var buttonLinearLayout: Button
    lateinit var buttonRelativeLayout: Button
    lateinit var buttonScrollView: Button
    lateinit var buttonConstraintLayout: Button
    lateinit var buttonLifeCycle: Button
    lateinit var buttonFragment: Button
    lateinit var buttonService: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        buttonLinearLayout = findViewById(R.id.buttonLinearLayout)
        buttonRelativeLayout = findViewById(R.id.buttonRelativeLayout)
        buttonScrollView = findViewById(R.id.buttonScrollView)
        buttonConstraintLayout = findViewById(R.id.buttonConstraintLayout)
        buttonLifeCycle = findViewById(R.id.buttonLifeCycle)
        buttonFragment = findViewById(R.id.buttonFragment)
        buttonService = findViewById(R.id.buttonService)
        buttonLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        buttonRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        buttonScrollView.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }
        buttonConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }
        buttonLifeCycle.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
        buttonFragment.setOnClickListener {
            val intent = Intent(this, FragmentTutorialActivity::class.java)
            startActivity(intent)
        }
        buttonService.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
    }
}
