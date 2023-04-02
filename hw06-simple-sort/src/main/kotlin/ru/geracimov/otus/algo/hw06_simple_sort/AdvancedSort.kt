package ru.geracimov.otus.algo.hw06_simple_sort

fun <T : Comparable<T>> Array<T>.selectionSort(): Array<T> {

    for (j in this.size - 1 downTo 1) {
        this.swap(indexOfMax(j), j)
    }
    return this
}

fun <T : Comparable<T>> Array<T>.heapSort(): Array<T> {
    for (index in this.size / 2 - 1 downTo 0) {
        heapify(index)
    }
    for (last in this.size - 1 downTo  0) {
        swap(0, last)
        heapify(0, last)
    }

    return this
}
