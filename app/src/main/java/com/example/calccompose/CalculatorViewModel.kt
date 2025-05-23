package com.example.calccompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

//we can't change the state from the outside but can access and read it


    fun onAction(action: CalculatorAction) {
        when (action) {

            is CalculatorAction.Number -> enterNumber(action.num)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> perfomDeletion()
        }
    }

    private fun perfomDeletion() {
        when {
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )

            state.operation != null -> state.copy(
                operation = null
            )

            state.num1.isNotBlank() -> state.copy(
                num1 = state.num1.dropLast(1)
            )

        }

    }

    private fun performCalculation() {
        val num1 = state.num1.toDoubleOrNull()
        val num2 = state.num2.toDoubleOrNull()
        if(num1 != null && num2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> num1 + num2
                is CalculatorOperation.Subtract -> num1 - num2
                is CalculatorOperation.Multiply -> num1 * num2
                is CalculatorOperation.Divide -> num1 / num2
                is CalculatorOperation.Modulus -> num1 % num2
                null -> return

            }
            state = state.copy(
                num1 = result.toString().take(15),
                num2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.num1.isNotBlank()) {
            state =
                state.copy(operation = operation)    //creates copy of state with this operation annd stores in state
        }

    }

    private fun enterDecimal() {
        if (state.operation == null && !state.num1.contains(".")
            && state.num1.isNotBlank()
        ) {
            state = state.copy(
                num1 = state.num1 + "."
            )
            return

        }

        if (!state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy(
                num1 = state.num2 + "."
            )
            return

        }

    }

    private fun enterNumber(num: Int) {

        if (state.operation == null) {
            if (state.num1.length >= MAX_NUM_LENGTH) {
                return
            }

            state=state.copy(
                num1 = state.num1 + num
            )
            return
        }
        if (state.num2.length >= MAX_NUM_LENGTH) {
            return
        }
        state=state.copy(
            num2 = state.num2 + num
        )
    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}