package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class BishopTest{

    private val rook: ChessFigure = Bishop()

    @Test
    fun getLeftBottomCornerMoves() {
        val moves = rook.getMoves(0)

        assertThat(moves).isEqualTo(9241421688590303744UL)
    }

    @Test
    fun getRightBottomCornerMoves() {
        val moves = rook.getMoves(7)

        assertThat(moves).isEqualTo(72624976668147712UL)
    }

    @Test
    fun getLeftTopCornerMoves() {
        val moves = rook.getMoves(56)

        assertThat(moves).isEqualTo(567382630219904UL)
    }

    @Test
    fun getRightTopCornerMoves() {
        val moves = rook.getMoves(63)

        assertThat(moves).isEqualTo(18049651735527937UL)
    }

    @Test
    fun getBottomBorderMoves() {
        val moves = rook.getMoves(3)

        assertThat(moves).isEqualTo(550848566272UL)
    }

    @Test
    fun getLeftBorderMoves() {
        val moves = rook.getMoves(24)

        assertThat(moves).isEqualTo(1155177711057110024UL)
    }

    @Test
    fun getRightBorderMoves() {
        val moves = rook.getMoves(55)

        assertThat(moves).isEqualTo(4611756524879479810UL)
    }

    @Test
    fun getTopBorderMoves() {
        val moves = rook.getMoves(61)

        assertThat(moves).isEqualTo(22667548931719168UL)
    }

    @Test
    fun getCenterMoves() {
        val moves = rook.getMoves(35)

        assertThat(moves).isEqualTo(4693335752243822976UL)
    }
}