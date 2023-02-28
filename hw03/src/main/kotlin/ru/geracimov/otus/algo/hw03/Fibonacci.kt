package ru.geracimov.otus.algo.hw03

import java.math.BigDecimal
import java.math.BigDecimal.ONE
import java.math.BigDecimal.ZERO
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt

interface Fibonacci {
    fun get(number: Int): BigDecimal
}

class IterateFibonacci : Fibonacci {

    override fun get(number: Int): BigDecimal {
        if (number <= 1) {
            return BigDecimal.valueOf(number.toLong())
        }
        var grandPrev = ZERO
        var prev = ONE
        var curr = prev

        for (i in 2..number) {
            curr = prev + grandPrev
            grandPrev = prev
            prev = curr
        }
        return curr
    }

}

class RecursionFibonacci : Fibonacci {

    override fun get(number: Int): BigDecimal {
        if (number <= 1) {
            return BigDecimal.valueOf(number.toLong())
        }
        return get(number - 1) + get(number - 2)
    }

}

class FormulaFibonacci : Fibonacci {
    private val sqrt5 = sqrt(5.0)
    private val fi = (1 + sqrt5) / 2

    override fun get(number: Int): BigDecimal {
        return BigDecimal(fi.pow(number) / sqrt5 + 0.5).setScale(0, RoundingMode.DOWN)
    }

}

class MatrixFibonacci : Fibonacci {
    private val m = Matrix(ONE, ONE, ONE, ZERO)

    override fun get(number: Int): BigDecimal {
        if (number == 0) return m.a22
        return m.pow(number - 1).a11
    }

    private class Matrix(
        var a11: BigDecimal, var a12: BigDecimal,
        var a21: BigDecimal, var a22: BigDecimal
    ) {

        operator fun times(m: Matrix): Matrix {
            return Matrix(
                a11 = a11 * m.a11 + a12 * m.a21, a12 = a11 * m.a12 + a12 * m.a22,
                a21 = a21 * m.a11 + a22 * m.a21, a22 = a21 * m.a12 + a22 * m.a22
            )
        }

        fun pow(power: Int): Matrix {
            if (power < 0) throw RuntimeException("power cannot be less 0")

            var pow = power
            var num = this
            var result = Matrix(ONE, ZERO, ZERO, ONE)
            while (pow >= 1) {
                if (pow % 2 == 1)
                    result *= num
                num *= num
                pow /= 2
            }
            return result
        }

        override fun toString(): String {
            return """
            |$a11    $a12|
            |$a21    $a22|
            """.trimIndent()
        }

    }

}
