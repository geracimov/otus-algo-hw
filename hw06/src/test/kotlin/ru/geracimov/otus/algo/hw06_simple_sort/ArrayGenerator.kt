package ru.geracimov.otus.algo.hw06_simple_sort

import java.util.*

interface ArrayGenerator<T> {
    fun shuffle(size: Int): Array<T>
    fun sorted(size: Int): Array<T>
    fun reverse(size: Int): Array<T>
}


class IntArrayGenerator(private val bound: Int = 10_000_000, seed: Long = 0L) : ArrayGenerator<Int> {
    private val random = Random(seed)
    override fun shuffle(size: Int): Array<Int> {
        return IntArray(size) {
            random.nextInt(bound)
        }.toTypedArray()
    }

    override fun sorted(size: Int): Array<Int> {
        return shuffle(size).sortedArray()
    }

    override fun reverse(size: Int): Array<Int> {
        return shuffle(size).sortedArrayDescending()
    }

}