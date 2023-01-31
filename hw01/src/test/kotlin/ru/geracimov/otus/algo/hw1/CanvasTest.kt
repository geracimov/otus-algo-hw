package ru.geracimov.otus.algo.hw1

import org.junit.jupiter.api.Test

class CanvasTest {

    @Test
    fun Fun1Test() {
        Canvas().draw(25, 25) { x, y ->
            x > y
        }
    }

    @Test
    fun Fun2Test() {
        Canvas().draw(25, 25) { x, y ->
            x == y
        }
    }

    @Test
    fun Fun3Test() {
        Canvas().draw(25, 25) { x, y ->
            x == 24 - y
        }
    }

    @Test
    fun Fun4Test() {
        Canvas().draw(25, 25) { x, y ->
            x + y < 30
        }
    }

    @Test
    fun Fun5Test() {
        Canvas().draw(25, 25) { x, y ->
            //todo
            (x + y).mod(3) > 3
        }
    }

    @Test
    fun Fun6Test() {
        Canvas().draw(25, 25) { x, y ->
            x < 10 || y < 10
        }
    }

    @Test
    fun Fun7Test() {
        Canvas().draw(25, 25) { x, y ->
            x > 15 && y > 15
        }
    }

    @Test
    fun Fun8Test() {
        Canvas().draw(25, 25) { x, y ->
            x * y == 0
        }
    }

    @Test
    fun Fun9Test() {
        Canvas().draw(25, 25) { x, y ->
             //todo
            true
        }
    }

    @Test
    fun Fun11Test() {
        Canvas().draw(25, 25) { x, y ->
            x == 1 || y == 1 || x == 23 || y == 23
        }
    }

    @Test
    fun Fun18Test() {
        Canvas().draw(25, 25) { x, y ->
            (x < 2 || y < 2)
        }
    }

    @Test
    fun Fun19Test() {
        Canvas().draw(25, 25) { x, y ->
            x == 0 || y == 0 || x == 24 || y == 24
        }
    }

    @Test
    fun Fun20Test() {
        Canvas().draw(25, 25) { x, y ->
            (x + y).mod(2) == 0
        }
    }

    @Test
    fun Fun22Test() {
        Canvas().draw(25, 25) { x, y ->
            (x + y).mod(3) == 0
        }
    }

    @Test
    fun Fun24Test() {
        Canvas().draw(25, 25) { x, y ->
            x == y || x == 24 - y
        }
    }
}