package ru.geracimov.otus.algo.hw03

interface Exponentiation {
    fun exponent(number: Double, power: Int): Double
}

class IterateExponentiation : Exponentiation {

    override fun exponent(number: Double, power: Int): Double {
        if (power < 0) throw RuntimeException("power cannot be less 0")
        if (power == 0) return 1.0
        if (power == 1) return number

        var result: Double = number
        for (i in 2..power) {
            result *= number
        }
        return result
    }

}
class Division2Exponentiation : Exponentiation {

    override fun exponent(number: Double, power: Int): Double {
        if (power < 0) throw RuntimeException("power cannot be less 0")
        if (power == 0) return 1.0
        if (power == 1) return number

        var n = power
        var d = number
        var p = 1.0
        while (n >= 1) {
            n /= 2
            d *= d
            if (n % 2 == 1) {
                p *= d
            }
        }
        if (power % 2 == 1) {
            p *= number
        }

        return p
    }

}