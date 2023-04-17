package ru.geracimov.otus.algo.hw06_simple_sort

import assertk.assertThat
import assertk.assertions.isTrue

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.concurrent.TimeUnit

class SortTest {
    private lateinit var generator: IntArrayGenerator
    private val assertArrayIsSorted = true

    @BeforeEach
    fun setUp() {
        generator = IntArrayGenerator(0xCAFEBABE)
    }

    @ParameterizedTest(name = "[{index}] algorithm={1} - generator={2} - size={0}")
    @MethodSource("arguments")
    @Execution(ExecutionMode.CONCURRENT)
    @Timeout(value = 120, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    fun sortArray(
        size: Int,
        algorithm: Function1<Array<Int>, Array<Int>>,
        generator: Function2<IntArrayGenerator, Int, Array<Int>>
    ) {
        val array = generator(this.generator, size)
        algorithm(array)
        if (assertArrayIsSorted) assertThat(array.isSorted()).isTrue()
    }


    companion object {

        @JvmStatic
        fun arguments(): MutableList<Arguments> {
            val arguments = mutableListOf<Arguments>()

            for (algorithm in algorithms) {
                for (generator in generators) {
                    for (size in sizes) {
                        arguments.add(Arguments.of(size, algorithm, generator))
                    }
                }
            }

            return arguments
        }

        private val algorithms = sequenceOf(
            Array<Int>::bubbleSort,
            Array<Int>::insertionSort,
            Array<Int>::insertionShiftSort,
            Array<Int>::insertionShiftBinarySearchSort,
            Array<Int>::shellSort,
            Array<Int>::selectionSort,
            Array<Int>::heapSort,
            Array<Int>::quickSort,
            Array<Int>::mergeSort,
            Array<Int>::bucketSort,
            Array<Int>::countingSort,
            Array<Int>::radixSort,
        )

        private val generators = sequenceOf(
            IntArrayGenerator::random,
            IntArrayGenerator::digits,
            IntArrayGenerator::limit1k,
            IntArrayGenerator::sorted,
            IntArrayGenerator::reverse
        )

        private val sizes = sequenceOf(
            1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000
        )
    }
}