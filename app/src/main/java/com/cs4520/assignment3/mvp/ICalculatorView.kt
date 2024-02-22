package com.cs4520.assignment3.mvp

interface ICalculatorView {
    fun showResult(result:String)
    fun clearInput()
    fun showError(message:String)
}