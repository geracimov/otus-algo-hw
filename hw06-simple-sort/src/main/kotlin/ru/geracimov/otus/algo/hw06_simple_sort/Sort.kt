package ru.geracimov.otus.algo.hw06_simple_sort


fun <T : Comparable<T>> Array<T>.binarySearch(k: T, low: Int, high: Int): Int {
    if (high <= low) {
        return if (k >= this[low]) {
            low + 1
        } else low
    }
    val mid = (low + high) / 2
    return if (k > this[mid]) {
        binarySearch(k, mid + 1, high)
    } else {
        binarySearch(k, low, mid - 1)
    }
}

fun <T> Array<T>.swap(i: Int, j: Int) {
    val ai = this[i]
    this[i] = this[j]
    this[j] = ai
}

fun <T : Comparable<T>> Array<T>.indexOfMax(size: Int = this.size - 1): Int {
    var max = 0
    for (i in 1..size) {
        if (this[i] > this[max]) {
            max = i
        }
    }
    return max
}

fun <T : Comparable<T>> Array<T>.indexOfMax(a: Int, b: Int, c: Int, size: Int = this.size): Int {
    var max = a
    if (b < size && this[b] > this[max]) max = b
    if (c < size && this[c] > this[max]) max = c
    return max
}

fun <T : Comparable<T>> Array<T>.heapify(root: Int, size: Int = this.size): Array<T> {
    val left = 2 * root + 1
    val right = 2 * root + 2
    val max = indexOfMax(root, left, right, size)
    if (max == root) return this

    swap(root, max)
    heapify(max, size)
    return this
}

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
    return (1 until size).none { this[it - 1] > this[it] }
}