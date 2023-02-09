package ru.geracimov.otus.algo.hw2

import java.util.logging.Logger

class LuckyTicketCalculator {
    private val cache: MutableMap<Int, Array<Int>> = mutableMapOf()

    companion object {
        val log: Logger = Logger.getLogger(LuckyTicketCalculator::class.java.simpleName)
    }

    /**
     * @param n: размерность цифр билета, n=3, билет из 2n цифр, например: "123 456"
     * @param numberSystem: система исчисления, по дефолту используются десятичные числа
     * */
    fun getCount(n: Int, numberSystem: Int = 10): Long {
        if (n < 1) throw RuntimeException("Размерность цифр билета не божет быть менее 1")
        if (numberSystem < 2) throw RuntimeException("Система исчисления не божет быть менее 2")
        var line = Array(numberSystem) { 1 }
        for (i in 2..n) {
            line = cache.getOrPut(numberSystem * 10000 + i) {
                calcNewLine(numberSystem, i, line)
            }
        }
        return calculate(line)
    }

    private fun calcNewLine(numberSystem: Int, n: Int, line: Array<Int>): Array<Int> {
        val length = (numberSystem - 1) * n + 1
        val matrix = Array(numberSystem) { Array(length) { 0 } }
        for ((i, ints) in matrix.withIndex()) {
            line.copyInto(ints, i)
        }
        log.fine(matrix.toStr())

        val newLine = Array(length) { 0 }

        for (j in newLine.indices) {
            for (element in matrix) {
                newLine[j] += element[j]
            }
        }

        return newLine
    }

    private fun calculate(line: Array<Int>): Long {
        return line.sumOf { it.toLong() * it.toLong() }
    }

    private fun Array<Array<Int>>.toStr(): String {
        return this.contentDeepToString()
            .replace("]", "")
            .replace("[", "\n")
    }

}
