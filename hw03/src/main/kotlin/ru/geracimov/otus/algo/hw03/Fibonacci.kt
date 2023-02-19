package ru.geracimov.otus.algo.hw03

import java.math.BigDecimal

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