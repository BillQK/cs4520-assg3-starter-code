package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mvpButton.setOnClickListener { navigateToMvp() }
        binding.mvvmButton.setOnClickListener { navigateToMvvm() }
    }

    private fun navigateToMvp() {
        findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
    }

    private fun navigateToMvvm() {
        findNavController().navigate(R.id.action_homeFragment_to_mvvmFragment)
    }
}
