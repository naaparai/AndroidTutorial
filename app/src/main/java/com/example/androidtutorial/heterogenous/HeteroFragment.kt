package com.example.androidtutorial.heterogenous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.androidtutorial.R
import com.example.androidtutorial.databinding.FragmentHeteroBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HeteroFragment : Fragment() {

    private val viewModel: HeteroViewModel by viewModels()

    @Inject
    lateinit var heteroAdapter: HeteroAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHeteroBinding>(
            inflater,
            R.layout.fragment_hetero,
            container,
            false
        )
        if (null == binding.rvHetero.adapter) {
            binding.rvHetero.adapter = heteroAdapter
        }
        binding.mySwitch.setOnCheckedChangeListener { compoundButton, b ->
            viewModel.removeImage(b)
        }
        lifecycleScope.launch {
            observeData()
        }
        return binding.root
    }

    private suspend fun observeData() {
        lifecycleScope.launch {
            viewModel.sectionDeleted.collect {
                heteroAdapter.deleteItem(it)
            }
        }
        lifecycleScope.launch {
            viewModel.sectionAdded.collect {
                heteroAdapter.insertCard(it)
            }
        }
    }
}
