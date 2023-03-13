package ru.geracimov.otus.algo.hw06_simple_sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

class SimpleSortKtTest {


    private lateinit var generator: IntArrayGenerator
    private lateinit var array: Array<Int>


    @BeforeEach
    fun setUp() {
        generator = IntArrayGenerator()
        array = generator.digits(100000)
        println(array.contentToString())
    }

    @Test
    fun bubbleSort() {
        println(array)
//        println(array.bubbleSort().contentToString())
        array.bubbleSort()
    }

    @Test
    fun insertionSort() {
//        println(array.insertionSort().contentToString())
        array.insertionSort()
    }

    @Test
    fun insertionShiftSort() {
//        println(array.insertionShiftSort().contentToString())
        array.insertionShiftSort()
    }

    @Test
    fun insertionShiftBinarySearchSort() {
//        println(array.insertionShiftBinarySearchSort().contentToString())
        array.insertionShiftBinarySearchSort()
    }

    @Test
    fun shellSort() {
//        println(array.shellSort().contentToString())
        array.shellSort()
    }

}