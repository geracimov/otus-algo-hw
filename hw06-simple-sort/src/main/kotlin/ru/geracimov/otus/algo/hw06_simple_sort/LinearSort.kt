package ru.geracimov.otus.algo.hw06_simple_sort

import java.util.StringJoiner

fun Array<Int>.radixSort(): Array<Int> {
    val radixCount = max().length()

    for (radixPosition in 1..radixCount) {
        val countArray = Array(10) { 0 }
        forEach {
            val radix = getRadix(it, radixPosition)
            countArray[radix]++
        }

        var sum = 0
        countArray.forEachIndexed { index, it ->
            sum += it
            countArray[index] = sum
        }

        val copy = Array(size) { 0 }
        for (index in this.indices.reversed()) {
            val radix = getRadix(this[index], radixPosition)
            val indexCopy = --countArray[radix]
            copy[indexCopy] = this[index]
        }

        copy.copyInto(this)
    }

    return this
}

fun Array<Int>.countingSort(): Array<Int> {
    val max = max()
    val min = min()
    val countArray = Array(max - min + 1) { 0 }

    forEach {
        countArray[it - min]++
    }

    var s = 0
    countArray.forEachIndexed { index, it ->
        s += it
        countArray[index] = s
    }


    val array2 = Array(size) { 0 }
    for (i in this.indices.reversed()) {
        val v = this[i]
        val i2 = --countArray[v - min]
        array2[i2] = v
    }

    return array2.copyInto(this)
}


fun Array<Int>.bucketSort(): Array<Int> {
    var max = this[0]
    forEach { if (it > max) max = it }
    //or var max = this.max()

    val bucket = Array<List<Int>?>(size) { null }
    forEach { a ->
        val b = ((1L * a * size) / (max + 1)).toInt()
        bucket[b] = List(a, bucket[b])

        var lst = bucket[b]
        while (lst?.next != null) {
            if (lst.value < lst.next!!.value) break
            lst.swap(lst.next!!)
            lst = lst.next
        }
    }

    var j = 0
    bucket.filterNotNull().forEach { lst ->
        var x: List<Int>? = lst
        while (x != null) {
            this[j++] = x.value
            x = x.next
        }
    }

    return this
}

class List<T : Comparable<T>>(var value: T, val next: List<T>?) {

    fun swap(nxt: List<T>) {
        val x = value
        value = nxt.value
        nxt.value = x
    }

    override fun toString(): String {
        val joiner = StringJoiner("->")
        joiner.add(value.toString())

        var x = this
        while (x.next != null) {
            val nxt = x.next!!
            joiner.add(nxt.value.toString())
            x = nxt
        }

        return joiner.toString()
    }
}

