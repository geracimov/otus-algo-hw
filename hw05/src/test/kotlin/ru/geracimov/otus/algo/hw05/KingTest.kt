package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class KingTest {

    private val king: ChessFigure = King()

    @Test
    fun getLeftBottomCornerMoves() {
        val moves = king.getMoves(0)

        assertThat(moves).isEqualTo(770UL)
    }

    @Test
    fun getRightBottomCornerMoves() {
        val moves = king.getMoves(7)

        assertThat(moves).isEqualTo(49216UL)
    }

    @Test
    fun getLeftTopCornerMoves() {
        val moves = king.getMoves(56)

        assertThat(moves).isEqualTo(144959613005987840UL)
    }

    @Test
    fun getRightTopCornerMoves() {
        val moves = king.getMoves(63)

        assertThat(moves).isEqualTo(4665729213955833856UL)
    }

    @Test
    fun getBottomBorderMoves() {
        val moves = king.getMoves(3)

        assertThat(moves).isEqualTo(7188UL)
    }

    @Test
    fun getLeftBorderMoves() {
        val moves = king.getMoves(24)

        assertThat(moves).isEqualTo(12918652928UL)
    }

    @Test
    fun getRightBorderMoves() {
        val moves = king.getMoves(55)

        assertThat(moves).isEqualTo(13853283560024178688UL)
    }

    @Test
    fun getTopBorderMoves() {
        val moves = king.getMoves(61)

        assertThat(moves).isEqualTo(5796132720425828352UL)
    }

    @Test
    fun getCenterMoves() {
        val moves = king.getMoves(35)

        assertThat(moves).isEqualTo(30872694685696UL)
    }
}