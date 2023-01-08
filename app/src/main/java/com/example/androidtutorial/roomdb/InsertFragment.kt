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
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.androidtutorial.R
import com.example.androidtutorial.databinding.FragmentInsertBinding
import kotlinx.coroutines.launch

class InsertFragment : Fragment() {

    private lateinit var db: AppDatabase
    private val viewModel: InsertViewModel by viewModels()

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
        val binding = DataBindingUtil.inflate<FragmentInsertBinding>(
            inflater,
            R.layout.fragment_insert,
            container,
            false
        )
        binding.buttonSave.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val user = User(firstName, lastName)
            lifecycleScope.launch {
                db.userDao().insertUser(user)
            }
        }
        binding.buttonShowList.setOnClickListener {
            findNavController().navigate(R.id.actionGotoDisplay)
        }
        return binding.root
    }
}
