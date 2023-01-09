package com.example.androidtutorial.roomdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtutorial.R
import com.example.androidtutorial.databinding.FragmentDisplayUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayUserFragment : Fragment() {
    private lateinit var binding: FragmentDisplayUserBinding
    private val viewModel: DisplayUserViewModel by viewModels()

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
        return binding.root
    }
}
