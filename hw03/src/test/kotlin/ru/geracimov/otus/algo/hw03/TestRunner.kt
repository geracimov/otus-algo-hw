package ru.geracimov.otus.algo.hw03

import assertk.assertThat
import assertk.assertions.isTrue
import com.github.freva.asciitable.AsciiTable
import com.github.freva.asciitable.Column
import com.github.freva.asciitable.ColumnData
import com.github.freva.asciitable.HorizontalAlign
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.nio.file.Path
import java.time.Duration
import java.time.Instant
import kotlin.Exception
import kotlin.io.path.*

internal class TestRunner {

    private lateinit var exponentiations: Array<Exponentiation>
    private lateinit var fibonacci: Array<Fibonacci>
    private lateinit var prime: Array<PrimeCounter>

    private lateinit var numbersInFilenameRegexp: Regex
    private lateinit var columns: List<ColumnData<Data>>

    @BeforeEach
    fun setUp() {
        exponentiations = arrayOf(
            IterateExponentiation(),
            Division2Exponentiation(),
        )
        fibonacci = arrayOf(
            IterateFibonacci(),
            RecursionFibonacci(),
            FormulaFibonacci(),
            MatrixFibonacci(),
        )
        prime = arrayOf(
            IteratePrimeCounter(),
            PrimesBasedPrimeCounter(),
            EratosthenesPrimeCounter(),
            EratosthenesBitSetPrimeCounter(),
        )
        numbersInFilenameRegexp = ".*?(\\d+).*".toRegex()
        columns = listOf<ColumnData<Data>>(
            Column().with { it.num.toString() },
            Column().header("task").with { it.task },
            Column().header("input file").with { it.inputFilename },
            Column().header("output file").with { it.outputFilename },
            Column().header("impl").with { it.impl },
            Column().header("input").with { it.input },
            Column().header("expected value").with { it.expected.trim() },
            Column().header("actual value").with { it.actual?.trim() },
            Column().header("success?").dataAlign(HorizontalAlign.CENTER)
                .with { if (it.success) "\u2705" else "\u274C" },
            Column().header("time, ns").with { it.time.toString() },
        )
    }

    @Test
    fun runPowerTests() {
        val resources = Path.of("src/test/resources/power")
        val data = mutableListOf<Data>()

        var i = 1
        resources.listDirectoryEntries("*.in")
            .sortedBy { numbersInFilenameRegexp.matchEntire(it.name)?.groups?.get(1)?.value?.toInt() ?: 0 }
            .forEach {
                val inputFilename = it.name

                val number = it.readLines()[0].toDouble()
                val power = it.readLines()[1].toLong()

                val resFiles = it.parent.listDirectoryEntries("${it.nameWithoutExtension}.out")
                assert(resFiles.size == 1) { "OUT files not found or more then one" }

                val outputFilename = resFiles[0]
                val expected = outputFilename.readLines()[0].toDouble()

                for (impl in exponentiations) {
                    val start = Instant.now()
                    var actual = -1.0
                    var success = false
                    var failedException = ""
                    try {
                        actual = impl.exponent(number, power)
                        success = true
                    } catch (e: Exception) {
                        println("Exception")
                        failedException = e.localizedMessage
                    }

                    val finish = Instant.now()
                    val millis = Duration.between(start, finish).toNanos()

                    Data(
                        num = i++,
                        task = "Power",
                        inputFilename = inputFilename,
                        outputFilename = outputFilename.name,
                        impl = impl.javaClass.simpleName,
                        input = "number=$number, power=$power",
                        expected = expected.toString(),
                        actual = if (success) actual.toString() else failedException,
                        success = actual.minus(0.0000001) < expected && actual.plus(0.0000001) > expected,
                        time = millis
                    ).addTo(data)
                }
            }
        println(AsciiTable.getTable(data, columns))
        assertThat(data.success()).isTrue()
    }

    @Test
    fun runAllFibonacciTests() {
        val resources = Path.of("src/test/resources/fibo")
        val data = mutableListOf<Data>()

        var i = 1
        resources.listDirectoryEntries("*.in")
            .sortedBy { numbersInFilenameRegexp.matchEntire(it.name)?.groups?.get(1)?.value?.toInt() ?: 0 }.forEach {
                val inputFilename = it.name
                val number = it.readLines()[0].toInt()

                val resFiles = it.parent.listDirectoryEntries("${it.nameWithoutExtension}.out")
                assert(resFiles.size == 1) { "OUT files not found or more then one" }

                val outputFilename = resFiles[0]
                val expected = outputFilename.readLines()[0].toBigDecimal()

                for (impl in fibonacci) {
                    val start = Instant.now()
                    var actual: BigDecimal? = null
                    var success = false
                    var failedException: String? = null

                    try {
                        actual = impl.get(number)
                        success = true
                    } catch (e: Throwable) {
                        println(e.message)
                        failedException = e.message
                    }

                    val finish = Instant.now()
                    val millis = Duration.between(start, finish).toNanos()

                    Data(
                        num = i++,
                        task = "Fibonacci",
                        inputFilename = inputFilename,
                        outputFilename = outputFilename.name,
                        impl = impl.javaClass.simpleName,
                        input = "number=$number",
                        expected = expected.toString(),
                        actual = if (success) actual.toString() else failedException,
                        time = millis
                    ).addTo(data)
                }
            }
        println(AsciiTable.getTable(data, columns))
        assertThat(data.success()).isTrue()
    }

    @Test
    fun runAllPrimeTests() {
        val resources = Path.of("src/test/resources/primes")

        val data = mutableListOf<Data>()
        var i = 1
        resources.listDirectoryEntries("*.in")
            .sortedBy { numbersInFilenameRegexp.matchEntire(it.name)?.groups?.get(1)?.value?.toInt() ?: 0 }.forEach {
                val inputFilename = it.name

                val number = it.readLines()[0].toLong()

                val resFiles = it.parent.listDirectoryEntries("${it.nameWithoutExtension}.out")
                assert(resFiles.size == 1) { "OUT files not found or more then one" }

                val outputFilename = resFiles[0]
                val expected = outputFilename.readLines()[0].toBigDecimal()

                for (impl in prime) {
                    val start = Instant.now()
                    var actual: Int? = null
                    var success = false
                    var failedException: String? = null
                    try {
                        actual = impl.get(number)
                        success = true
                    } catch (e: Throwable) {
                        println(e.message)
                        failedException = e.message
                    }
                    val finish = Instant.now()
                    val millis = Duration.between(start, finish).toNanos()

                    Data(
                        num = i++,
                        task = "Prime",
                        inputFilename = inputFilename,
                        outputFilename = outputFilename.name,
                        impl = impl.javaClass.simpleName,
                        input = "number=$number",
                        expected = expected.toString(),
                        actual = if (success) actual.toString() else failedException,
                        time = millis
                    ).addTo(data)

                }
            }
        println(AsciiTable.getTable(data, columns))
        assertThat(data.success()).isTrue()
    }
}

fun MutableList<Data>.success(): Boolean {
    return this.stream().allMatch { it.success }
}

fun String.trim(limit: Int = 30): String {
    return if (length < limit) this else "${substring(0 until limit)}... (size=$length) ..."
}

data class Data(
    val num: Int,
    val task: String,
    val inputFilename: String,
    val outputFilename: String,
    val impl: String,
    val input: String,
    val expected: String,
    val actual: String?,
    val success: Boolean = expected == actual,
    val time: Long,
) {
    fun addTo(c: MutableList<Data>) {
        c.add(this)
    }
}