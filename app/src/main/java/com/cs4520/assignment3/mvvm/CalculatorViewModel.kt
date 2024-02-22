package com.cs4520.assignment3.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val model = CalculatorModel()
    val result = MutableLiveData<String>()
    val error = MutableLiveData<String>()

    fun onAddClicked(firstNumber: String, secondNumber: String) {
        calculate(firstNumber, secondNumber, model::add)
    }

    fun onSubtractClicked(firstNumber: String, secondNumber: String) {
        calculate(firstNumber, secondNumber, model::subtract)
    }

    fun onMultiplyClicked(firstNumber: String, secondNumber: String) {
        calculate(firstNumber, secondNumber, model::multiply)
    }

    fun onDivideClicked(firstNumber: String, secondNumber: String) {
        calculate(firstNumber, secondNumber, model::divide)
    }

    private fun calculate(
        firstNumber: String?, secondNumber: String?, operation: (Double, Double)
        -> Double
    ) {
        try {
            val n1 = firstNumber?.toDoubleOrNull()
            val n2 = secondNumber?.toDoubleOrNull()
            if (n1 == null || n2 == null) {
                error.value = "Invalid Input"
                return
            }
            result.value = operation(n1, n2).toString()
        } catch (e: ArithmeticException) {
            error.value = e.message ?: "Error in arithmetic operation"
        }
    }

}
