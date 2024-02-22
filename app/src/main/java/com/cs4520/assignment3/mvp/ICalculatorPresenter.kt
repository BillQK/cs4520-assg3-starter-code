package com.cs4520.assignment3.mvp

import android.text.Editable

interface ICalculatorPresenter {
    fun onAddClicked(firstNumber: Editable, secondNumber: Editable)
    fun onSubtractClicked(firstNumber: Editable, secondNumber: Editable)
    fun onMultiplyClicked(firstNumber: Editable, secondNumber: Editable)
    fun onDivideClicked(firstNumber: Editable, secondNumber: Editable)
}