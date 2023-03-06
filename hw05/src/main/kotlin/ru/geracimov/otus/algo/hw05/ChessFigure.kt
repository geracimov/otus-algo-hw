package ru.geracimov.otus.algo.hw05

import ru.geracimov.otus.algo.hw05.ChessFigure.Companion.row1
import ru.geracimov.otus.algo.hw05.ChessFigure.Companion.columnA
import ru.geracimov.otus.algo.hw05.ChessFigure.Companion.diagonalLeft
import ru.geracimov.otus.algo.hw05.ChessFigure.Companion.diagonalRight

interface ChessFigure {
    companion object {
        val row1: ULong = 0xffUL
        val columnA: ULong = 0x101010101010101UL
        val exceptColumnA: ULong = 0xfefefefefefefefeUL
        val exceptColumnH: ULong = 0x7f7f7f7f7f7f7f7fUL
        val exceptColumnAB: ULong = 0xfcfcfcfcfcfcfcfcUL
        val exceptColumnGH: ULong = 0x3f3f3f3f3f3f3f3fUL
        val diagonalLeft: ULong = 0x8040201008040201UL
        val diagonalRight: ULong = 0x102040810204080UL
    }

    fun getMoves(position: Int): ULong

    fun getBitPosition(position: Int) = 1UL shl position
}

interface DiagonalChessFigure : ChessFigure {
    fun getDiagonalMoves(position: Int): ULong {
        val rowIndex = position shr 3
        val columnIndex = position % 8

        val left: ULong = if (rowIndex > columnIndex) {
            val shift = (rowIndex - columnIndex) shl 3
            diagonalLeft shl shift
        } else {
            val shift = (columnIndex - rowIndex) shl 3
            diagonalLeft shr shift
        }


        val right: ULong = if (rowIndex + columnIndex > 7) {
            val shift = ((rowIndex + columnIndex) - 7) shl 3
            diagonalRight shl shift
        } else {
            val shift = (7 - (rowIndex + columnIndex)) shl 3
            diagonalRight shr shift
        }

        return left xor right
    }
}

interface HorizontalVerticalChessFigure : ChessFigure {
    fun getHorizontalVerticalMoves(position: Int): ULong {
        val shiftRateHorizontal = (position shr 3) shl 3
        val row = row1 shl shiftRateHorizontal

        val shiftRateVertical = position and 7
        val column = columnA shl shiftRateVertical

        return row xor column
    }
}
