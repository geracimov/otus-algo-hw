package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

class EratosthenesPrimeCounterTest {

    lateinit var counter: PrimeCounter

    @BeforeEach
    fun setUp() {
        counter = EratosthenesPrimeCounter()
    }

    @Test
    fun getCountIn1() {
        assertThat(counter.get(1)).isEqualTo(0)
    }

    @Test
    fun getCountIn2() {
        assertThat(counter.get(2)).isEqualTo(1)
    }

    @Test
    fun getCountIn3() {
        assertThat(counter.get(3)).isEqualTo(2)
    }

    @Test
    fun getCountIn10() {
        assertThat(counter.get(10)).isEqualTo(4)
    }

    @Test
    fun getCountIn100() {
        assertThat(counter.get(100)).isEqualTo(25)
    }

    @Test
    fun getCountIn1000() {
        assertThat(counter.get(1_000)).isEqualTo(168)
    }

    @Test
    fun getCountIn10000() {
        assertThat(counter.get(10_000)).isEqualTo(1229)
    }

    @Test
    fun getCountIn100000() {
        assertThat(counter.get(100_000)).isEqualTo(9592)
    }

    @Test
    fun getCountIn1000000() {
        assertThat(counter.get(1_000_000)).isEqualTo(78498)
    }

    @Test
    fun getCountIn10000000() {
        assertThat(counter.get(10_000_000)).isEqualTo(664579)
    }

    @Test
    fun getCountIn100000000() {
        assertThat(counter.get(100_000_000)).isEqualTo(5761455)
    }

}