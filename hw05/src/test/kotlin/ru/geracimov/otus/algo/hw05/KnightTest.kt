package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class KnightTest {

    private val knight: ChessFigure = Knight()

    @Test
    fun getLeftBottomCornerMoves() {
        val moves = knight.getMoves(0)

        assertThat(moves).isEqualTo(132096UL)
    }

    @Test
    fun getRightBottomCornerMoves() {
        val moves = knight.getMoves(7)

        assertThat(moves).isEqualTo(4202496UL)
    }

    @Test
    fun getLeftTopCornerMoves() {
        val moves = knight.getMoves(56)

        assertThat(moves).isEqualTo(1128098930098176UL)
    }

    @Test
    fun getRightTopCornerMoves() {
        val moves = knight.getMoves(63)

        assertThat(moves).isEqualTo(9077567998918656UL)
    }

    @Test
    fun getBottomBorderMoves() {
        val moves = knight.getMoves(3)

        assertThat(moves).isEqualTo(1319424UL)
    }

    @Test
    fun getLeftBorderMoves() {
        val moves = knight.getMoves(24)

        assertThat(moves).isEqualTo(2216203387392UL)
    }

    @Test
    fun getRightBorderMoves() {
        val moves = knight.getMoves(55)

        assertThat(moves).isEqualTo(2305878468463689728UL)
    }

    @Test
    fun getTopBorderMoves() {
        val moves = knight.getMoves(61)

        assertThat(moves).isEqualTo(38368557762871296UL)
    }

    @Test
    fun getCenterMoves() {
        val moves = knight.getMoves(35)

        assertThat(moves).isEqualTo(5666883501293568UL)
    }
}