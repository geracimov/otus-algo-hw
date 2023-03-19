package ru.geracimov.otus.algo.hw06_simple_sort


fun <T : Comparable<T>> Array<T>.bubbleSort(): Array<T> {

    for (j in indices.reversed()) { //sorted part
        for (i in 0 until j) {
            if (this[i] > this[j]) {
                this.swap(i, j)
            }
        }
    }
    return this
}

fun <T : Comparable<T>> Array<T>.insertionSort(): Array<T> {
    for (j in indices) { //sorted part
        var i = j - 1
        while (i >= 0 && this[i] > this[i + 1]) {
            this.swap(i, i + 1)
            i--
        }
    }
    return this
}

fun <T : Comparable<T>> Array<T>.insertionShiftSort(): Array<T> {
    for (j in indices) { //sorted part
        val k = this[j]
        var i = j - 1
        while (i >= 0 && this[i] > k) {
            this[i + 1] = this[i]
            i--
        }
        this[i + 1] = k
    }
    return this
}

fun <T : Comparable<T>> Array<T>.insertionShiftBinarySearchSort(): Array<T> {
    for (j in indices) { //sorted part
        val k = this[j]
        val p = this.binarySearch(k, 0, j - 1)
        var i = j - 1
        while (i >= p) {
            this[i + 1] = this[i]
            i--
        }
        this[i + 1] = k
    }
    return this
}

fun <T : Comparable<T>> Array<T>.shellSort(): Array<T> {
    var gap = this.size / 2
    while (gap > 0) {
        for (i in gap until this.size) {
            var j = i
            while (j >= gap && this[j - gap] > this[j]) {
                swap(j - gap, j)
                j -= gap
            }
        }
        gap /= 2
    }
    return this
}
