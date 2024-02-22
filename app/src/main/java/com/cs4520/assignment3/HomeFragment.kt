package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private lateinit var mvpButton: Button
    private lateinit var mvvmButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpButton = view.findViewById(R.id.mvpButton)
        mvvmButton = view.findViewById(R.id.mvvmButton)

        mvpButton.setOnClickListener { navigateToMvp() }
        mvvmButton.setOnClickListener { navigateToMvvm() }
    }

    private fun navigateToMvp() {
        findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
    }

    private fun navigateToMvvm() {
        findNavController().navigate(R.id.action_homeFragment_to_mvvmFragment)
    }
}
