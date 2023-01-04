package com.example.androidtutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.androidtutorial.R

class SecondFragment : Fragment() {
    lateinit var viewFragment2: View
    lateinit var textViewFragment2: TextView
    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment2 = inflater.inflate(R.layout.fragment_second, container, false)
        textViewFragment2 = viewFragment2.findViewById(R.id.textViewFragment2)
        val myText = "Name = ${args.name} and Id = ${args.id}"
        textViewFragment2.text = myText
        return viewFragment2
    }
}
