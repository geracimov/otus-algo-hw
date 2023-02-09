package ru.geracimov.otus.algo.hw2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class LuckyTicketCalculatorTest {
    lateinit var calculator: LuckyTicketCalculator

    @BeforeEach
    fun setUp() {
        calculator = LuckyTicketCalculator()
    }

    @Test
    fun getNs10CountFor2() {
        val count10For2 = calculator.getCount(2)

        assertEquals(670, count10For2)
    }

    @Test
    fun getNs10CountFor3() {
        val count10For3 = calculator.getCount(3)

        assertEquals(55252, count10For3)
    }

    /**
     * Билеты из 2 ращзрядов в двоичной системе
     *         00 00
     *         01 01
     *         10 10
     *         11 11
     *         10 01
     *         01 10
     * */
    @Test
    fun getNs2CountFor2() {
        val count10For2 = calculator.getCount(2, 2)

        assertEquals(6, count10For2)
    }
}