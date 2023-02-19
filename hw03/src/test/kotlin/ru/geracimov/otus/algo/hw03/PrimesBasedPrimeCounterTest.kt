package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

class PrimesBasedPrimeCounterTest {

    lateinit var counter: PrimeCounter

    @BeforeEach
    fun setUp() {
        counter = PrimesBasedPrimeCounter()
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
        assertThat(counter.get(1000)).isEqualTo(168)
    }

    @Test
    fun getCountIn10000() {
        assertThat(counter.get(10000)).isEqualTo(1229)
    }

    @Test
    fun getCountIn100000() {
        assertThat(counter.get(100000)).isEqualTo(9592)
    }

    @Test
    fun getCountIn1000000() {
        assertThat(counter.get(1000000)).isEqualTo(78498)
    }

    @Test
    fun getCountIn10000000() {
        assertThat(counter.get(10000000)).isEqualTo(664579)
    }

    @Test
    fun getCountIn100000000() {
        assertThat(counter.get(100000000)).isEqualTo(5761455)
    }
}