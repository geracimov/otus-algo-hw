package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import assertk.assertions.hasToString
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import java.math.BigDecimal

class IterateFibonacciTest {

    private lateinit var fibonacci: Fibonacci

    @BeforeEach
    fun setUp() {
        fibonacci = IterateFibonacci()
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
    fun get80Test() {
        assertThat(fibonacci.get(80)).isEqualTo(BigDecimal.valueOf(23416728348467685L))
    }

    @Test
    fun get1000Test() {
        assertThat(fibonacci.get(1000)).hasToString("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875")
    }
}