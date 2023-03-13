package ru.geracimov.otus.algo.hw06_simple_sort

import java.util.*

interface ArrayGenerator<T> {
    fun random(size: Int, bound: Int = Int.MAX_VALUE): Array<T>
    fun digits(size: Int): Array<T>
    fun sorted(size: Int): Array<T>
    fun reverse(size: Int): Array<T>
}


class IntArrayGenerator(seed: Long = 0L) : ArrayGenerator<Int> {
    private val random = Random(seed)
    override fun random(size: Int, bound: Int): Array<Int> {
        return Array(size) { random.nextInt(bound) }
    }

    override fun digits(size: Int): Array<Int> {
        return random(size, 10)
    }

    override fun sorted(size: Int): Array<Int> {
        return Array(size) { it }
    }

    override fun reverse(size: Int): Array<Int> {
        return Array(size) { size - it - 1 }
    }

}