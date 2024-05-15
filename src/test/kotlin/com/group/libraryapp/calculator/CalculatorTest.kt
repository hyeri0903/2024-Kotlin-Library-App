package com.group.libraryapp.calculator

import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun addTest() {
        val calculator = Calculator(5)
        calculator.add(3)

        val expectedResult = Calculator(8)

        if (calculator != expectedResult) {
            throw IllegalStateException()
        }
    }
}