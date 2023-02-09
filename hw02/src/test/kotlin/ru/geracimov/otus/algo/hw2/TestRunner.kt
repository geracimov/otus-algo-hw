package ru.geracimov.otus.algo.hw2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.nio.file.Path
import kotlin.io.path.*

internal class TestRunner {
    private lateinit var calculator: LuckyTicketCalculator

    @BeforeEach
    fun setUp() {
        calculator = LuckyTicketCalculator()
    }

    @Test
    fun runAllTests() {
        val resources = Path.of("src/test/resources/data")
        println("Searching data in $resources...")

        resources.listDirectoryEntries("*.in").forEach {
            println("Found in file ${it.name}")
            val n = it.readText().toInt()
            println("n=$n")

            val resFiles = it.parent.listDirectoryEntries("${it.nameWithoutExtension}.out")
            println("Found OUT files for IN file \"${it.name}\": $resFiles")
            assert(resFiles.size == 1) { "OUT files not found or more then one" }

            val expected = resFiles[0].readText().trim().toLong()
            val actual = calculator.getCount(n)

            println("expected result=$expected, actual=$actual")
            assertEquals(expected, actual)
        }
    }
}