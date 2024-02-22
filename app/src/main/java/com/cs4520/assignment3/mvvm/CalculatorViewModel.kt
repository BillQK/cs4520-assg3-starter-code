package com.cs4520.assignment3.mvvm

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.CalculatorModel

class CalculatorViewModel : ViewModel() {
    private val model = CalculatorModel()
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun onAddClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::add)
    }

    fun onSubtractClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::subtract)
    }

    fun onMultiplyClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::multiply)
    }

    fun onDivideClicked(firstNumber: Editable, secondNumber: Editable) {
        executeOperation(firstNumber, secondNumber, model::divide)
    }

    private fun executeOperation(
        firstNumber: Editable, secondNumber: Editable, operation: (Double, Double)
        -> Double
    ) {
        try {
            val n1 = firstNumber.toString().toDoubleOrNull()
            val n2 = secondNumber.toString().toDoubleOrNull()
            if (n1 == null || n2 == null) {
                _error.value = "Invalid Input"
                _error.value = "" // a hack for not showing the toast when error has occur before
                return
            }
            _result.value = operation(n1, n2).toString()
            _error.value = "" // a hack for not showing the toast when error has occur before
        } catch (e: ArithmeticException) {
            _error.value = e.message ?: "Error in arithmetic operation"

        }
    }

}
