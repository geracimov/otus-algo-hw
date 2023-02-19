package ru.geracimov.otus.algo.hw03

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt

interface Fibonacci {
    fun get(number: Int): BigDecimal
}

class IterateFibonacci : Fibonacci {

    override fun get(number: Int): BigDecimal {
        if (number <= 1) {
            return BigDecimal.valueOf(number.toLong())
        }
        var grandPrev = BigDecimal.ZERO
        var prev = BigDecimal.ONE
        var curr = prev

        for (i in 2..number) {
            curr = prev + grandPrev
            grandPrev = prev
            prev = curr
        }
        return curr
    }

}

class RecursionFibonacci : Fibonacci {

    override fun get(number: Int): BigDecimal {
        if (number <= 1) {
            return BigDecimal.valueOf(number.toLong())
        }
        return get(number - 1) + get(number - 2)
    }

}

class FormulaFibonacci : Fibonacci {
    private val sqrt5 = sqrt(5.0)
    private val fi = (1 + sqrt5) / 2

    override fun get(number: Int): BigDecimal {
        return BigDecimal(fi.pow(number) / sqrt5 + 0.5).setScale(0, RoundingMode.DOWN)
    }

}