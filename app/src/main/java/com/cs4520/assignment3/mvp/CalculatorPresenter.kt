package com.cs4520.assignment3.mvp

import android.text.Editable
import com.cs4520.assignment3.CalculatorModel
import java.lang.ArithmeticException

class CalculatorPresenter(private val view: ICalculatorView) : ICalculatorPresenter {
    private val model: CalculatorModel = CalculatorModel()

    override fun onAddClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::add)
    }

    override fun onSubtractClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::subtract)
    }

    override fun onMultiplyClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::multiply)
    }

    override fun onDivideClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::divide)
    }

    private fun executeOperation(
        firstNumber: Editable, secondNumber: Editable,
        operation: (Double, Double) -> Double
    ) {
        try {
            val n1 = firstNumber.toString().toDoubleOrNull()
            val n2 = secondNumber.toString().toDoubleOrNull()
            if (n1 == null || n2 == null) {
                view.showError("Invalid Input")
                return
            }
            val result = operation(n1, n2)
            view.clearInput()
            view.showResult(result.toString())
        } catch (e: ArithmeticException) {
            view.showError("Cannot divide 0")
            view.clearInput()
        }
    }
}