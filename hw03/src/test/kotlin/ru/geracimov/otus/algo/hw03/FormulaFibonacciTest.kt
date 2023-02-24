package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import java.math.BigDecimal

class FormulaFibonacciTest {

    private lateinit var fibonacci: Fibonacci

    @BeforeEach
    fun setUp() {
        fibonacci = FormulaFibonacci()
    }

    @Test
    fun get0Test() {
        assertThat(fibonacci.get(0)).isEqualTo(BigDecimal.ZERO)
    }

    @Test
    fun get1Test() {
        assertThat(fibonacci.get(1)).isEqualTo(BigDecimal.ONE)
    }

    @Test
    fun get2Test() {
        assertThat(fibonacci.get(2)).isEqualTo(BigDecimal.ONE)
    }

    @Test
    fun get3Test() {
        assertThat(fibonacci.get(3)).isEqualTo(BigDecimal.valueOf(2))
    }

    @Test
    fun get4Test() {
        assertThat(fibonacci.get(4)).isEqualTo(BigDecimal.valueOf(3))
    }

    @Test
    fun get5Test() {
        assertThat(fibonacci.get(5)).isEqualTo(BigDecimal.valueOf(5))
    }

    @Test
    fun get6Test() {
        assertThat(fibonacci.get(6)).isEqualTo(BigDecimal.valueOf(8))
    }

    @Test
    fun get7Test() {
        assertThat(fibonacci.get(7)).isEqualTo(BigDecimal.valueOf(13))
    }

    @Test
    fun get8Test() {
        assertThat(fibonacci.get(8)).isEqualTo(BigDecimal.valueOf(21))
    }

    @Test
    fun get9Test() {
        assertThat(fibonacci.get(9)).isEqualTo(BigDecimal.valueOf(34))
    }

    @Test
    fun get10Test() {
        assertThat(fibonacci.get(10)).isEqualTo(BigDecimal.valueOf(55))
    }
    @Test
    fun get64Test() {
        assertThat(fibonacci.get(64)).isEqualTo(BigDecimal.valueOf(10610209857723))
    }

}