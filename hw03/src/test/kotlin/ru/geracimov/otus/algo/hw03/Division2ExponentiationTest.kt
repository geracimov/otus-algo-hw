package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.geracimov.otus.algo.hw03.assertion.isCloseToWithDelta

class Division2ExponentiationTest {

    private lateinit var exponentation: Exponentiation

    @BeforeEach
    fun setUp() {
        exponentation = Division2Exponentiation()
    }

    @Test
    fun exponent2in6() {
        val actual = exponentation.exponent(2.0, 6)

        assertThat(actual).isCloseToWithDelta(64.0)
    }

    @Test
    fun exponent3in8() {
        val actual = exponentation.exponent(3.0, 8)

        assertThat(actual).isCloseToWithDelta(6561.0)
    }

    @Test
    fun exponent3in9() {
        val actual = exponentation.exponent(3.0, 9)

        assertThat(actual).isCloseToWithDelta(19683.0)
    }

    @Test
    fun exponent3in10() {
        val actual = exponentation.exponent(3.0, 10)

        assertThat(actual).isCloseToWithDelta(59049.0)
    }

    @Test
    fun exponent4in13() {
        val actual = exponentation.exponent(4.0, 13)

        assertThat(actual).isCloseToWithDelta(67108864.0)
    }

    @Test
    fun exponent2in100() {
        val actual = exponentation.exponent(2.0, 100)

        assertThat(actual).isCloseToWithDelta(1.2676506002282294E30)
    }

    @Test
    fun exponent18in5() {
        val actual = exponentation.exponent(18.0, 5)

        assertThat(actual).isCloseToWithDelta(1889568.0)
    }

    @Test
    fun exponent1001in1000() {
        val actual = exponentation.exponent(1.001, 1000)

        assertThat(actual).isCloseToWithDelta(2.7169239322355203)
    }

    @Test
    fun exponent6in1() {
        val actual = exponentation.exponent(6.0, 1)

        assertThat(actual).isCloseToWithDelta(6.0)
    }

    @Test
    fun exponent43in0() {
        val actual = exponentation.exponent(43.0, 0)

        assertThat(actual).isCloseToWithDelta(1.0)
    }
    @Test
    fun exponent3in2() {
        val actual = exponentation.exponent(3.0, 2)

        assertThat(actual).isCloseToWithDelta(9.0)
    }
    @Test
    fun exponent3in3() {
        val actual = exponentation.exponent(3.0, 3)

        assertThat(actual).isCloseToWithDelta(27.0)
    }


}