package ru.geracimov.otus.algo.hw05

object BitCounter {

    private val bits = (0UL until 256UL).map { it.countOneBits() }.toTypedArray()
    private const val mask_1 = 0x5555555555555555UL   // 0101 0101 0101 0101 ...
    private const val mask_2 = 0x3333333333333333UL   // 0011 0011 0011 0011 ...
    private const val mask_4 = 0x0f0f0f0f0f0f0f0fUL   // 0000 1111 0000 1111 ...
    private const val mask_8 = 0x00ff00ff00ff00ffUL   // 0000 0000 1111 1111 ...

    fun ULong.countOneBitsShift(): Int {
        var msk = this
        var count = 0

        while (msk > 0UL) {
            count += (msk and 1UL).toInt()
            msk = msk shr 1
        }
        return count
    }

    fun ULong.countOneBitsAmp(): Int {
        var msk = this
        var count = 0

        while (msk > 0UL) {
            count += 1
            msk = msk and (msk - 1UL)
        }
        return count
    }

    fun ULong.countOneBitsCache(): Int {
        var msk = this
        var count = 0

        while (msk > 0UL) {
            val index = (msk and 255UL).toInt()
            count += bits[index]
            msk = msk shr 8
        }
        return count
    }

    fun ULong.countOneBitsHabr(): Int {
        if (this == 0UL) return 0

        var x = (this and mask_1) + ((this shr 1) and mask_1)
        x = (x and mask_2) + (x shr 2 and mask_2)
        x = (x and mask_4) + (x shr 4 and mask_4)
        x = (x and mask_8) + (x shr 8 and mask_8)

        val y = x.toInt() + (x shr 32).toInt()

        return (y + (y shr 16)) and 0x3f
    }

}
