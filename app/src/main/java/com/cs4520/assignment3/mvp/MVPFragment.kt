package com.cs4520.assignment3.mvp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.CalculatorFragmentBinding

class MVPFragment : Fragment(), ICalculatorView {
    private lateinit var binding: CalculatorFragmentBinding
    private lateinit var presenter: CalculatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = CalculatorFragmentBinding.inflate(layoutInflater)
        binding.root.setBackgroundColor(Color.parseColor("#c4b8e1"))

        presenter = CalculatorPresenter(this)

        setupButtons()

        return binding.root
    }

    private fun setupButtons() {
        binding.addButton.setOnClickListener {
            presenter.onAddClicked(
                binding.number1.text,
                binding.number2.text
            )
        }

        binding.subtractButton.setOnClickListener {
            presenter.onSubtractClicked(
                binding.number1.text,
                binding.number2.text
            )
        }

        binding.multiplyButton.setOnClickListener {
            presenter.onMultiplyClicked(
                binding.number1.text,
                binding.number2.text
            )
        }

        binding.divideButton.setOnClickListener {
            presenter.onDivideClicked(
                binding.number1.text,
                binding.number2.text
            )
        }
    }

    override fun showResult(result: String) {
        binding.resultView.text = buildString {
            append("Result: ")
            append(result)
        }
    }

    override fun clearInput() {
        binding.number1.text.clear()
        binding.number2.text.clear()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
