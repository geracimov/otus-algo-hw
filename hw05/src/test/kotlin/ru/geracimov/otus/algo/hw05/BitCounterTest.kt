package ru.geracimov.otus.algo.hw05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import ru.geracimov.otus.algo.hw05.BitCounter.countOneBitsAmp
import ru.geracimov.otus.algo.hw05.BitCounter.countOneBitsCache
import ru.geracimov.otus.algo.hw05.BitCounter.countOneBitsHabr
import ru.geracimov.otus.algo.hw05.BitCounter.countOneBitsShift

class BitCounterTest {

    @Test
    fun countOneBitsShift() {
        assertThat(4466776735872UL.countOneBitsShift()).isEqualTo(6)
    }

    @Test
    fun countOneBitsAmp() {
        assertThat(4466776735872UL.countOneBitsAmp()).isEqualTo(6)
    }

    @Test
    fun countOneBitsCache() {
        assertThat(4466776735872UL.countOneBitsCache()).isEqualTo(6)
    }

    @Test
    fun countOneBitsHabr() {
        assertThat(4466776735872UL.countOneBitsHabr()).isEqualTo(6)
    }

    @Test
    fun countOneBitsKotlin() {
        assertThat(4466776735872UL.countOneBits()).isEqualTo(6)
    }

}