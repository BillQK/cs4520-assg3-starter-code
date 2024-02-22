package com.cs4520.assignment3.mvp

class CalculatorModel : ICalculatorModel {

    private var result: Double = 0.0

    override fun add(firstNumber: Double, secondNumber: Double): Double {
        result = firstNumber + secondNumber
        return result
    }

    override fun subtract(firstNumber: Double, secondNumber: Double): Double {
        result = firstNumber - secondNumber
        return result
    }

    override fun multiply(firstNumber: Double, secondNumber: Double): Double {
        result = firstNumber * secondNumber
        return result
    }

    override fun divide(firstNumber: Double, secondNumber: Double): Double {
        if (secondNumber == 0.0) {
            throw ArithmeticException("Cannot divide with 0")
        }
        result = firstNumber / secondNumber
        return result
    }

}