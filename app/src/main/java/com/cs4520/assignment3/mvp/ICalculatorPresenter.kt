package com.cs4520.assignment3.mvp

interface ICalculatorPresenter {
    fun onAddClicked(firstNumber: String?, secondNumber: String?)
    fun onSubtractClicked(firstNumber: String?, secondNumber: String?)
    fun onMultiplyClicked(firstNumber: String?, secondNumber: String?)
    fun onDivideClicked(firstNumber: String?, secondNumber: String?)
}