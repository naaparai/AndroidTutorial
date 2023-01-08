package com.example.androidtutorial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidtutorial.activitylifecycle.FirstActivity
import com.example.androidtutorial.broadcast.BroadCastActivity
import com.example.androidtutorial.container.ConstraintActivity
import com.example.androidtutorial.container.LinearLayoutActivity
import com.example.androidtutorial.container.RelativeLayoutActivity
import com.example.androidtutorial.container.ScrollViewActivity
import com.example.androidtutorial.coroutine.CoroutineActivity
import com.example.androidtutorial.databinding.ActivityTutorialBinding
import com.example.androidtutorial.fragment.FragmentTutorialActivity
import com.example.androidtutorial.roomdb.RoomDbActivity
import com.example.androidtutorial.service.ServiceActivity

class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityTutorialBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_tutorial
        )

        binding.buttonLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        binding.buttonRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        binding.buttonScrollView.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }
        binding.buttonConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }
        binding.buttonLifeCycle.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
        binding.buttonFragment.setOnClickListener {
            val intent = Intent(this, FragmentTutorialActivity::class.java)
            startActivity(intent)
        }
        binding.buttonService.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        binding.buttonBroadCast.setOnClickListener {
            val intent = Intent(this, BroadCastActivity::class.java)
            startActivity(intent)
        }
        binding.buttonCoroutine.setOnClickListener {
            val intent = Intent(this, CoroutineActivity::class.java)
            startActivity(intent)
        }
        binding.buttonRoomDb.setOnClickListener {
            val intent = Intent(this, RoomDbActivity::class.java)
            startActivity(intent)
        }
    }
}
