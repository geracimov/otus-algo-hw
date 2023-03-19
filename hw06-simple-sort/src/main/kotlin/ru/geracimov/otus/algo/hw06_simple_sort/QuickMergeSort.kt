package ru.geracimov.otus.algo.hw06_simple_sort

fun <T : Comparable<T>> Array<T>.quickSort(): Array<T> {
    qSort(this, 0, this.size - 1)
    return this
}

fun <T : Comparable<T>> Array<T>.mergeSort(): Array<T> {
    mSort(this, 0, this.size - 1)
    return this
}


private fun <T : Comparable<T>> mSort(array: Array<T>, left: Int, right: Int) {
    if (left >= right) return
    val middle = (left + right) / 2
    mSort(array, left, middle)
    mSort(array, middle + 1, right)
    merge(array, left, middle, right)
}

@Suppress("UNCHECKED_CAST")
private fun <T : Comparable<T>> merge(array: Array<T>, left: Int, middle: Int, right: Int) {
    var a = left
    var b = middle + 1

    val temp = Array<Any>(right - left + 1) {
        if (a > middle && b <= right) array[b++]
        else
            if (a <= middle && b > right) array[a++]
            else
                if (array[a] < array[b]) array[a++] else array[b++]
    }
    for (i in left..right) {
        array[i] = temp[i - left] as T
    }
}

private fun <T : Comparable<T>> qSort(array: Array<T>, left: Int, right: Int) {
    if (left >= right) return
    val middle = split(array, left, right)
    qSort(array, left, middle - 1)
    qSort(array, middle, right)
}

private fun <T : Comparable<T>> split(array: Array<T>, left: Int, right: Int): Int {
    val base = array[right]
    var middle = left - 1
    for (j in left..right) {
        if (array[j] <= base) {
            array.swap(++middle, j)
        }
    }
    return middle
}
