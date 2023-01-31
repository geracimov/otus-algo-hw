package ru.geracimov.otus.algo.hw1

class Canvas {
    fun draw(w: Int, h: Int, f: (x: Int, y: Int) -> Boolean) {
        for (y in 0 until h) {
            for (x in 0 until w) {
                print(if (f(x, y)) "X " else ". ")
            }
            println()
        }
    }
}