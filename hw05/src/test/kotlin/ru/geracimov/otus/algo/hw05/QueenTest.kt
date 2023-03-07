package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class QueenTest {

    private val queen: ChessFigure = Queen()

    @Test
    fun getLeftBottomCornerMoves() {
        val moves = queen.getMoves(0)

        assertThat(moves).isEqualTo(9313761861428380670UL)
    }

    @Test
    fun getRightBottomCornerMoves() {
        val moves = queen.getMoves(7)

        assertThat(moves).isEqualTo(9332167099941961855UL)
    }

    @Test
    fun getLeftTopCornerMoves() {
        val moves = queen.getMoves(56)

        assertThat(moves).isEqualTo(18303478847064064385UL)
    }

    @Test
    fun getRightTopCornerMoves() {
        val moves = queen.getMoves(63)

        assertThat(moves).isEqualTo(9205534180971414145UL)
    }

    @Test
    fun getBottomBorderMoves() {
        val moves = queen.getMoves(3)

        assertThat(moves).isEqualTo(578721933553179895UL)
    }

    @Test
    fun getLeftBorderMoves() {
        val moves = queen.getMoves(24)

        assertThat(moves).isEqualTo(1227517888139822345UL)
    }

    @Test
    fun getRightBorderMoves() {
        val moves = queen.getMoves(55)

        assertThat(moves).isEqualTo(13871017173176583298UL)
    }

    @Test
    fun getTopBorderMoves() {
        val moves = queen.getMoves(61)

        assertThat(moves).isEqualTo(16100553540994408480UL)
    }

    @Test
    fun getCenterMoves() {
        val moves = queen.getMoves(35)

        assertThat(moves).isEqualTo(5272058161445620104UL)
    }
}