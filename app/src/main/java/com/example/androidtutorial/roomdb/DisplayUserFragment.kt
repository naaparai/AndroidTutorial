package com.example.androidtutorial.roomdb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.example.androidtutorial.R
import com.example.androidtutorial.databinding.FragmentDisplayUserBinding
import com.example.androidtutorial.roomdb.repo.UserRepoImpl

class DisplayUserFragment : Fragment() {
    private lateinit var binding: FragmentDisplayUserBinding
    private lateinit var db: AppDatabase
    private val viewModel: DisplayUserViewModel by viewModels()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database-name"
        ).build()
        val userRepo = UserRepoImpl(db.userDao())
        viewModel.initUserRepo(userRepo)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_display_user,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.load()
        observeData()
        return binding.root
    }

    private fun observeData() {
    }
}
