package com.cs4520.assignment3.mvvm

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.CalculatorFragmentBinding


class MVVMFragment : Fragment() {
    private val viewModel: CalculatorViewModel by viewModels()
    private lateinit var binding: CalculatorFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CalculatorFragmentBinding.inflate(layoutInflater)
        binding.root.setBackgroundColor(Color.parseColor("#ffb3ba"))

        viewModel.result.observe(viewLifecycleOwner, Observer { result ->
            clearInput()
            if (result.isNotEmpty()) {
                binding.resultView.text = buildString {
                    append("Result: ")
                    append(result)
                }
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { message ->
            if (message.isNotEmpty()) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        })

        setupButtons(binding.root)

        return binding.root
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            viewModel.onAddClicked(
                binding.number1.text.toString(),
                binding.number2.text.toString()
            )
        }

        view.findViewById<Button>(R.id.subtractButton).setOnClickListener {
            viewModel.onSubtractClicked(
                binding.number1.text.toString(),
                binding.number2.text.toString()
            )
        }

        view.findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            viewModel.onMultiplyClicked(
                binding.number1.text.toString(),
                binding.number2.text.toString()
            )
        }

        view.findViewById<Button>(R.id.divideButton).setOnClickListener {
            viewModel.onDivideClicked(
                binding.number1.text.toString(),
                binding.number2.text.toString()
            )
        }

    }

    private fun clearInput() {
        binding.number1.text.clear()
        binding.number2.text.clear()
    }

}