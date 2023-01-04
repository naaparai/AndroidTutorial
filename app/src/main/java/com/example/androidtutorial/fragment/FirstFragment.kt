package com.example.androidtutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtutorial.R

class FirstFragment : Fragment() {
    lateinit var fragmentView: View
    lateinit var textViewFragment1: TextView
    lateinit var buttonGotoSecond: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentView = inflater.inflate(R.layout.fragment_first, container, false)
        textViewFragment1 = fragmentView.findViewById(R.id.textViewFragment1)
        buttonGotoSecond = fragmentView.findViewById(R.id.buttonGotoSecond)
        buttonGotoSecond.setOnClickListener {
            /*  val bundle = Bundle()
              bundle.putInt("myInt", 10)
              findNavController().navigate(R.id.secondFragment, bundle)*/
            val action = FirstFragmentDirections.actionGotoSecond(10, "Kunsang")
            findNavController().navigate(action)
        }

        return fragmentView
    }
}
