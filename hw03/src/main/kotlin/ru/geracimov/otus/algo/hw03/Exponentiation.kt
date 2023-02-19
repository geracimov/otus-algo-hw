package ru.geracimov.otus.algo.hw03

interface Exponentiation {
    fun exponent(number: Double, power: Int): Double
}

class IterateExponentiation : Exponentiation {

    override fun exponent(number: Double, power: Int): Double {
        if (power < 0) throw RuntimeException("power cannot be less 0")

        var result = 1.0
        for (i in 0 until power) {
            result *= number
        }
        return result
    }

}

class Division2Exponentiation : Exponentiation {

    override fun exponent(number: Double, power: Int): Double {
        if (power < 0) throw RuntimeException("power cannot be less 0")

        var pow = power
        var num = number
        var result = 1.0
        while (pow >= 1) {
            if (pow % 2 == 1)
                result *= num
            num *= num
            pow /= 2
        }
        return result
    }

}