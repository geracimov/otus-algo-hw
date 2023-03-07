package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RookTest {


    private val rook: ChessFigure = Rook()

    @Test
    fun getLeftBottomCornerMoves() {
        val moves = rook.getMoves(0)

        assertThat(moves).isEqualTo(72340172838076926UL)
    }

    @Test
    fun getRightBottomCornerMoves() {
        val moves = rook.getMoves(7)

        assertThat(moves).isEqualTo(9259542123273814143UL)
    }

    @Test
    fun getLeftTopCornerMoves() {
        val moves = rook.getMoves(56)

        assertThat(moves).isEqualTo(18302911464433844481UL)
    }

    @Test
    fun getRightTopCornerMoves() {
        val moves = rook.getMoves(63)

        assertThat(moves).isEqualTo(9187484529235886208UL)
    }

    @Test
    fun getBottomBorderMoves() {
        val moves = rook.getMoves(3)

        assertThat(moves).isEqualTo(578721382704613623UL)
    }

    @Test
    fun getLeftBorderMoves() {
        val moves = rook.getMoves(24)

        assertThat(moves).isEqualTo(72340177082712321UL)
    }

    @Test
    fun getRightBorderMoves() {
        val moves = rook.getMoves(55)

        assertThat(moves).isEqualTo(9259260648297103488UL)
    }

    @Test
    fun getTopBorderMoves() {
        val moves = rook.getMoves(61)

        assertThat(moves).isEqualTo(16077885992062689312UL)
    }

    @Test
    fun getCenterMoves() {
        val moves = rook.getMoves(35)

        assertThat(moves).isEqualTo(578722409201797128UL)
    }

}