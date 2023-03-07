package ru.geracimov.otus.algo.hw05


class King : ChessFigure {
    override fun getMoves(position: Int): ULong {
        val k = getBitPosition(position)
        val ka = k and ChessFigure.exceptColumnA
        val kh = k and ChessFigure.exceptColumnH

        return (ka shl 7) or (k shl 8) or (kh shl 9) or (kh shl 1) or
                (kh shr 7) or (k shr 8) or (ka shr 9) or (ka shr 1)
    }

}

class Knight : ChessFigure {
    override fun getMoves(position: Int): ULong {
        val k = getBitPosition(position)

        val ka = k and ChessFigure.exceptColumnA
        val kh = k and ChessFigure.exceptColumnH

        val kab = k and ChessFigure.exceptColumnAB
        val kgh = k and ChessFigure.exceptColumnGH

        return (kab shl 6) or (kh shl 10) or (ka shl 15) or (kh shl 17) or
                (kgh shr 6) or (ka shr 10) or (kh shr 15) or (ka shr 17)
    }

}

class Rook : HorizontalVerticalChessFigure {
    override fun getMoves(position: Int): ULong = getHorizontalVerticalMoves(position)

}

class Bishop : DiagonalChessFigure {
    override fun getMoves(position: Int): ULong = getDiagonalMoves(position)

}

class Queen : DiagonalChessFigure, HorizontalVerticalChessFigure {
    override fun getMoves(position: Int): ULong = getDiagonalMoves(position) or getHorizontalVerticalMoves(position)

}