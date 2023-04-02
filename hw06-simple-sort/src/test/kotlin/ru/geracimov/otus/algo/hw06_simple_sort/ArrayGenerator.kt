package ru.geracimov.otus.algo.hw06_simple_sort

import java.util.*

interface ArrayGenerator<T> {
    fun random(size: Int): Array<T>
    fun digits(size: Int): Array<T>
    fun sorted(size: Int): Array<T>
    fun reverse(size: Int): Array<T>
}


class IntArrayGenerator(seed: Long = 0L) : ArrayGenerator<Int> {
    private val random = Random(seed)
    private fun generateArray(size: Int, bound: Int): Array<Int> = Array(size) { random.nextInt(bound) }

    override fun random(size: Int): Array<Int> {
        return generateArray(size, Int.MAX_VALUE)
    }

    override fun digits(size: Int): Array<Int> {
        return generateArray(size, 10)
    }

    override fun sorted(size: Int): Array<Int> {
        return Array(size) { it }
    }

    override fun reverse(size: Int): Array<Int> {
        return Array(size) { size - it - 1 }
    }

}