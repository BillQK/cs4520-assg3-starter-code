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


class MVVMFragment : Fragment() {
    private val viewModel: CalculatorViewModel by viewModels()
    private lateinit var firstNumberInput: EditText
    private lateinit var secondNumberInput: EditText
    private lateinit var resultField: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.calculator_fragment, container, false)
        view.setBackgroundColor(Color.parseColor("#ffb3ba"))

        firstNumberInput = view.findViewById(R.id.number1)
        secondNumberInput = view.findViewById(R.id.number2)
        resultField = view.findViewById(R.id.resultView)


        viewModel.result.observe(viewLifecycleOwner, Observer { result ->
            clearInput()
            if (result.isNotEmpty()) {
                "${resultField.text} $result".also { resultField.text = it }
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { message ->
            if (message.isNotEmpty()) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        })

        setupButtons(view)

        return view
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.addbutton).setOnClickListener {
            viewModel.onAddClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.substractButton).setOnClickListener {
            viewModel.onSubtractClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            viewModel.onMultiplyClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.divideButton).setOnClickListener {
            viewModel.onDivideClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

    }

    private fun clearInput() {
        firstNumberInput.text.clear()
        secondNumberInput.text.clear()
        "Result:".also { resultField.text = it }
    }

}