package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import ru.geracimov.otus.algo.hw03.assertion.isCloseToWithDelta

class IterateExponentiationTest {

    private lateinit var exponentation: Exponentiation

    @BeforeEach
    fun setUp() {
        exponentation = IterateExponentiation()
    }

    @Test
    fun exponent2in6() {
        assertThat(exponentation.exponent(2.0, 6)).isCloseToWithDelta(64.0)
    }

    @Test
    fun exponent18in5() {
        assertThat(exponentation.exponent(18.0, 5)).isCloseToWithDelta(1889568.0)
    }

    @Test
    fun exponent1001in1000() {
        assertThat(exponentation.exponent(1.001, 1000)).isCloseToWithDelta(2.7169239322)
    }

    @Test
    fun exponent6in1() {
        assertThat(exponentation.exponent(6.0, 1)).isCloseToWithDelta(6.0)
    }

    @Test
    fun exponent43in0() {
        assertThat(exponentation.exponent(43.0, 0)).isCloseToWithDelta(1.0)
    }

}