package ru.geracimov.otus.algo.hw03

import kotlin.math.roundToLong
import kotlin.math.sqrt

interface PrimeCounter {
    fun get(number: Long): Int
}


class IteratePrimeCounter : PrimeCounter {
    override fun get(number: Long): Int {
        var count = 0

        for (i in 1..number) {
            if (isPrime(i)) {
                count++
            }
        }
        return count
    }

    private fun isPrime(number: Long): Boolean {
        if (number == 2L) return true
        if (number % 2 == 0L || number == 1L) return false

        for (i in 3..sqrt(number.toDouble()).roundToLong() step 2) {
            if (number % i == 0L) {
                return false
            }
        }

        return true
    }

}
