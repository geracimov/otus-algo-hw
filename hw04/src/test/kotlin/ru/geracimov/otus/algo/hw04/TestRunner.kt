package ru.geracimov.otus.algo.hw04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.Duration
import java.time.Instant
import java.util.*

class TestRunner {

    @ParameterizedTest
    @MethodSource("arrayImplStream")
    fun name(size: Int, array: CustomArray<Int>, classname: String) {
        print("PUT \t $classname")
        var ms = putOnEnd(array, size)
        println("\t $ms ms")

        print("GET \t $classname")
        ms = getValue(array, size)
        println("\t $ms ms")

//        print("PUT 0 \t $classname")
//        ms = putOnBegin(array, size)
//        println("\t $ms ms")
    }

    companion object {
        @JvmStatic
        fun arrayImplStream() = listOf(
            Arguments.of(1_000, SingleArray<Int>(), "SingleArray"),
            Arguments.of(1_000, VectorArray<Int>(), "VectorArray"),
            Arguments.of(1_000, FactorArray<Int>(), "FactorArray"),
            Arguments.of(1_000, MatrixArray<Int>(), "MatrixArray"),
            Arguments.of(10_000, WrappedArrayList<Int>(), "WrappedList"),

            Arguments.of(10_000, SingleArray<Int>(), "SingleArray"),
            Arguments.of(10_000, VectorArray<Int>(), "VectorArray"),
            Arguments.of(10_000, FactorArray<Int>(), "FactorArray"),
            Arguments.of(10_000, MatrixArray<Int>(), "MatrixArray"),
            Arguments.of(10_000, WrappedArrayList<Int>(), "WrappedList"),

            Arguments.of(100_000, SingleArray<Int>(), "SingleArray"),
            Arguments.of(100_000, VectorArray<Int>(), "VectorArray"),
            Arguments.of(100_000, FactorArray<Int>(), "FactorArray"),
            Arguments.of(100_000, MatrixArray<Int>(), "MatrixArray"),
            Arguments.of(100_000, WrappedArrayList<Int>(), "WrappedList"),

            Arguments.of(1_000_000, FactorArray<Int>(), "FactorArray"),
            Arguments.of(1_000_000, MatrixArray<Int>(), "MatrixArray"),
            Arguments.of(1_000_000, WrappedArrayList<Int>(), "WrappedList"),
        )
    }
}

fun putOnBegin(array: CustomArray<Int>, size: Int): Long {
    val started = Instant.now()
    for (i in 0..size) {
        array.put(256, 0)
    }
    return Duration.between(started, Instant.now()).toMillis()
}

fun putOnEnd(array: CustomArray<Int>, size: Int): Long {
    val started = Instant.now()
    for (i in 0..size) {
        array.put(256)
    }
    return Duration.between(started, Instant.now()).toMillis()
}

fun getValue(array: CustomArray<Int>, size: Int): Long {
    val random = Random()
    val started = Instant.now()
    for (i in 0..size) {
        array.get(random.nextInt(size))
    }
    return Duration.between(started, Instant.now()).toMillis()
}