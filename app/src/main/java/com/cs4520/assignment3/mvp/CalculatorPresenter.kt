package com.cs4520.assignment3.mvp

import java.lang.ArithmeticException

class CalculatorPresenter(private val view: ICalculatorView) : ICalculatorPresenter {
    private val model: CalculatorModel = CalculatorModel()

    override fun onAddClicked(firstNumber: String?, secondNumber: String?) {
        executeOperation(firstNumber, secondNumber, model::add)
    }

    override fun onSubtractClicked(firstNumber: String?, secondNumber: String?) {
        executeOperation(firstNumber, secondNumber, model::subtract)
    }

    override fun onMultiplyClicked(firstNumber: String?, secondNumber: String?) {
        executeOperation(firstNumber, secondNumber, model::multiply)
    }

    override fun onDivideClicked(firstNumber: String?, secondNumber: String?) {
        executeOperation(firstNumber, secondNumber, model::divide)
    }

    private fun executeOperation(
        firstNumber: String?, secondNumber: String?,
        operation: (Double, Double) -> Double
    ) {
        try {
            val n1 = firstNumber?.toDoubleOrNull()
            val n2 = secondNumber?.toDoubleOrNull()
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