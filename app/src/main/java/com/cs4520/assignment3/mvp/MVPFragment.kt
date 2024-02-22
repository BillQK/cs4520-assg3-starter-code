package com.cs4520.assignment3.mvp

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
import com.cs4520.assignment3.R

class MVPFragment : Fragment(), ICalculatorView {
    private lateinit var firstNumberInput: EditText
    private lateinit var secondNumberInput: EditText
    private lateinit var resultField: TextView
    private lateinit var presenter: CalculatorPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.calculator_fragment, container, false)
        view.setBackgroundColor(Color.parseColor("#c4b8e1"))

        firstNumberInput = view.findViewById(R.id.number1)
        secondNumberInput = view.findViewById(R.id.number2)
        resultField = view.findViewById(R.id.resultView)
        presenter = CalculatorPresenter(this)

        setupButtons(view)

        return view
    }

    private fun setupButtons(view: View) {
        view.findViewById<Button>(R.id.addbutton).setOnClickListener {
            presenter.onAddClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.substractButton).setOnClickListener {
            presenter.onSubtractClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            presenter.onMultiplyClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

        view.findViewById<Button>(R.id.divideButton).setOnClickListener {
            presenter.onDivideClicked(
                firstNumberInput.text.toString(),
                secondNumberInput.text.toString()
            )
        }

    }

    override fun showResult(result: String) {
        "${resultField.text} $result".also { resultField.text = it }
    }

    override fun clearInput() {
        firstNumberInput.text.clear()
        secondNumberInput.text.clear()
        "Result:".also { resultField.text = it }
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}
