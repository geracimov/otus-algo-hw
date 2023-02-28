package ru.geracimov.otus.algo.hw03

import java.util.BitSet
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

class PrimesBasedPrimeCounter : PrimeCounter {
    override fun get(number: Long): Int {
        if (number < 2) return 0
        var count = 0
        val size = (number / 2).toInt() + 1
        val primes = Array(size) { 0L }

        primes[count++] = 2

        for (i in 3..number step 2) {
            if (isPrime(i, primes)) {
                primes[count++] = i
            }
        }
        return count
    }

    private fun isPrime(number: Long, primes: Array<Long>): Boolean {
        if (number == 2L) return true
        if (number % 2 == 0L || number == 1L) return false

        var i = 0
        while (primes[i] <= sqrt(number.toDouble())) {
            if (number % primes[i] == 0L) {
                return false
            }
            i++
        }

        return true
    }

}

class EratosthenesPrimeCounter : PrimeCounter {
    override fun get(number: Long): Int {
        val array = BooleanArray(number.toInt() + 1) { true }
        array[0] = false
        array[1] = false

        for (i in 2 until array.size) {
            if (array[i]) {
                var j = 2
                while (i * j < array.size) {
                    array[i * j] = false
                    j++
                }
            }
        }
        return array.count { it }
    }

}

class EratosthenesBitSetPrimeCounter : PrimeCounter {
    override fun get(number: Long): Int {
        val bitSet = BitSet(number.toInt())
        bitSet.set(0, number.toInt() + 1, true)
        bitSet.set(0, false)
        bitSet.set(1, false)

        for (i in 2 until bitSet.length()) {
            if (bitSet[i]) {
                var j = 2
                while (i * j < bitSet.length()) {
                    bitSet[i * j] = false
                    j++
                }
            }
        }
        return bitSet.cardinality()
    }

}