package ru.geracimov.otus.algo.hw04

interface CustomArray<T> {

    fun put(item: T)
    fun get(index: Int): T?
    fun size(): Int
    fun isEmpty(): Boolean
    fun put(item: T, index: Int)
    fun del(index: Int): T?

}

abstract class AbstractArray<T> : CustomArray<T> {
    protected lateinit var array: Array<T>

    protected fun toString(iMax: Int = array.size - 1): String {
        if (iMax == -1) return "[]"
        val b = StringBuilder()
        b.append('[')
        var i = 0
        while (true) {
            b.append(array[i].toString())
            if (i == iMax) return b.append(']').toString()
            b.append(", ")
            i++
        }
    }

}

/**
 *  Базовая реализация массива
 * */
class SingleArray<T> : AbstractArray<T>() {

    init {
        array = arrayOf<Any>() as Array<T>
    }

    override fun put(item: T) {
        resize()
        array[size() - 1] = item
    }

    override fun get(index: Int): T {
        return array[index]
    }

    override fun size(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun put(item: T, index: Int) {
        array = Array<Any?>(size() + 1) { i ->
            when {
                i < index -> array[i]
                i == index -> item
                else -> array[i - 1]
            }
        } as Array<T>
    }

    override fun del(index: Int): T {
        val deleted: T = array[index]
        array = Array<Any?>(size() - 1) { i ->
            when {
                i < index -> array[i]
                else -> array[i + 1]
            }
        } as Array<T>
        return deleted
    }

    override fun toString(): String {
        return toString(array.size - 1)
    }

    private fun resize() {
        val newArray = arrayOfNulls<Any>(size() + 1) as Array<T>
        for (i in 0 until size()) {
            newArray[i] = array[i]
        }
        array = newArray
    }

}

/**
 *  Реализация массива с арифметическим увеличением размера
 * */
class VectorArray<T>(private val vector: Int = 10) : AbstractArray<T>() {
    private var size: Int

    init {
        array = arrayOf<Any>() as Array<T>
        size = 0
    }

    override fun put(item: T) {
        if (size() >= array.size) {
            resize()
        }
        array[size()] = item
        size++
    }

    override fun get(index: Int): T {
        return array[index]
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun put(item: T, index: Int) {
        array = Array<Any?>(size() + 1) { i ->
            when {
                i < index -> array[i]
                i == index -> item
                else -> array[i - 1]
            }
        } as Array<T>
    }

    override fun del(index: Int): T {
        if (index >= size) {
            throw IndexOutOfBoundsException("Index is oversized")
        }
        val deleted: T = array[index]
        array = Array<Any?>(size() - 1) { i ->
            when {
                i < index -> array[i]
                else -> array[i + 1]
            }
        } as Array<T>
        size++
        return deleted
    }

    override fun toString(): String {
        return toString(size - 1)
    }

    private fun resize() {
        val newArray = arrayOfNulls<Any>(size() + vector) as Array<T>
        for (i in 0 until size()) {
            newArray[i] = array[i]
        }
        array = newArray
    }

}

/**
 *  Реализация массива с кратным увеличением размера
 * */
class FactorArray<T>(private val factor: Int = 2) : AbstractArray<T>() {
    private var size: Int

    init {
        array = arrayOf<Any>(Int.MAX_VALUE) as Array<T>
        size = 0
    }

    override fun put(item: T) {
        if (size() >= array.size) {
            resize()
        }
        array[size()] = item
        size++
    }

    override fun get(index: Int): T {
        return array[index]
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun put(item: T, index: Int) {
        array = Array<Any?>(size() + 1) { i ->
            when {
                i < index -> array[i]
                i == index -> item
                else -> array[i - 1]
            }
        } as Array<T>
    }

    override fun del(index: Int): T {
        if (index >= size) {
            throw IndexOutOfBoundsException("Index is oversized")
        }
        val deleted: T = array[index]
        array = Array<Any?>(size() - 1) { i ->
            when {
                i < index -> array[i]
                else -> array[i + 1]
            }
        } as Array<T>
        size++
        return deleted
    }

    override fun toString(): String {
        return toString(size - 1)
    }

    private fun resize() {
        val newArray = arrayOfNulls<Any>(size() * factor) as Array<T>
        for (i in 0 until size()) {
            newArray[i] = array[i]
        }
        array = newArray
    }

}

/**
 *  Реализация матричного массива
 * */
class MatrixArray<T>(private val partSize: Int = 100) : CustomArray<T> {
    private var size: Int
    private var array: Array<Array<T>>

    init {
        val part = arrayOfNulls<Any>(partSize)
        array = arrayOf(part) as Array<Array<T>>
        size = 0
    }

    private fun partNumber(index: Int): Int {
        return index / partSize
    }

    private fun partPosition(index: Int): Int {
        return index % partSize
    }

    override fun put(item: T) {
        if (size() >= array.size * partSize) {
            resize()
        }
        array[partNumber(size())][partPosition(size())] = item
        size++
    }

    override fun get(index: Int): T {
        return array[partNumber(index)][partPosition(index)]
    }

    override fun size(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun put(item: T, index: Int) {
        if (size() >= array.size * partSize) {
            resize()
        }

        shiftForward(index)
        array[partNumber(index)][partPosition(index)] = item
        size++
    }

    private fun shiftForward(from: Int) {
        for (i in size downTo from + 1) {
            val partNumber = partNumber(i)
            val partPosition = partPosition(i)

            var prePartPosition = partPosition - 1
            var prePartNumber = partNumber

            if (prePartPosition < 0) {
                prePartPosition = partSize - 1
                prePartNumber -= 1
            }
            array[partNumber][partPosition] = array[prePartNumber][prePartPosition]
        }
    }

    private fun shiftBackward(to: Int) {
        for (i in to until size - 1) {
            val partNumber = partNumber(i)
            val partPosition = partPosition(i)

            var nextPartPosition = partPosition + 1
            var nextPartNumber = partNumber

            if (nextPartPosition >= partSize) {
                nextPartPosition = 0
                nextPartNumber += 1
            }
            array[partNumber][partPosition] = array[nextPartNumber][nextPartPosition]
        }
        size--
    }

    override fun del(index: Int): T {
        if (index >= size || index < 0) {
            throw IndexOutOfBoundsException("Index is oversized")
        }
        val deleted: T = array[partNumber(index)][partPosition(index)]
        shiftBackward(index)
        return deleted
    }

    override fun toString(): String {
        if (size == 0) return "[]"
        val b = StringBuilder("[")
        var i = 0
        while (true) {
            b.append(array[partNumber(i)][partPosition(i)].toString())
            if (i == size - 1) return b.append(']').toString()
            b.append(", ")
            i++
        }
    }

    private fun resize() {
        val newArray = arrayOfNulls<Array<Any?>>(array.size + 1) as Array<Array<T>>
        for (i in array.indices) {
            newArray[i] = array[i]
        }
        newArray[array.size] = arrayOfNulls<Any>(partSize) as Array<T>
        array = newArray
    }

}

/**
 *  Реализация обертки вокруг ArrayList
 * */
class WrappedArrayList<T> : CustomArray<T> {
    private val array: ArrayList<T> = ArrayList()

    override fun put(item: T) {
        array.add(item)
    }

    override fun put(item: T, index: Int) {
        array.add(index, item)
    }

    override fun get(index: Int): T? {
        return array[index]
    }

    override fun size(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty()
    }

    override fun del(index: Int): T? {
        return array.removeAt(index)
    }

    override fun toString(): String {
        return array.toString()
    }

}