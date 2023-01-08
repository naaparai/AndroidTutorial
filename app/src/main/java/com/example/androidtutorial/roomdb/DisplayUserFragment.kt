package com.example.androidtutorial.roomdb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.androidtutorial.R
import com.example.androidtutorial.databinding.FragmentDisplayUserBinding
import kotlinx.coroutines.launch

class DisplayUserFragment : Fragment() {

    private lateinit var db: AppDatabase
    private val viewModel: DisplayUserViewModel by viewModels()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database-name"
        ).build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentDisplayUserBinding>(
            inflater,
            R.layout.fragment_display_user,
            container,
            false
        )
        lifecycleScope.launch {
            val users = db.userDao().getAll().toString()
            binding.tvDisplay.text = users
        }
        return binding.root
    }
}
