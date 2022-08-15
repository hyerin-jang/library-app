package com.group.library.calculator

import com.group.libraryapp.calculator.Calculator
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("before all")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("after all")
        }
    }

    @Test
    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        assertThat(calculator.number).isEqualTo(2)

    }

    @Test
    fun multiplyTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)

        //then
        assertThat(calculator.number).isEqualTo(15)

    }

    @Test
    fun divideTest() {
        //given
        val calculator = Calculator(10)

        //when
        calculator.divide(2)

        //then
        assertThat(calculator.number).isEqualTo(5)

    }

    @Test
    fun divideExceptionTest() {
        // given
        val calculator = Calculator(5)

        // when & then
        assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.apply {
            assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
        }

    }
}