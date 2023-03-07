package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FactorArrayTest {
    private lateinit var factorArray: FactorArray<Int>

    @BeforeEach
    fun setUp() {
        factorArray = FactorArray()
        factorArray.put(1)
        factorArray.put(2)
        factorArray.put(3)
    }

    @Test
    fun putElementTest() {
        val sizeBefore = factorArray.size()

        factorArray.put(8)
        factorArray.put(50)
        factorArray.put(-60)
        val newSize = factorArray.size()

        assertThat(newSize).isEqualTo(sizeBefore + 3)
    }

    @Test
    fun getElementByIndexTest() {
        val actual = factorArray.get(1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun isEmptyTest() {
        assertThat(factorArray.isEmpty()).isFalse()

        assertThat(VectorArray<Any>().isEmpty()).isTrue()
    }

    @Test
    fun putElementByIndexInBeginningTest() {
        factorArray.put(666, 0)
        assertThat(factorArray.get(0)).isEqualTo(666)
        assertThat(factorArray.get(1)).isEqualTo(1)
        assertThat(factorArray.get(2)).isEqualTo(2)
        assertThat(factorArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInMiddleTest() {
        factorArray.put(666, 2)
        assertThat(factorArray.get(0)).isEqualTo(1)
        assertThat(factorArray.get(1)).isEqualTo(2)
        assertThat(factorArray.get(2)).isEqualTo(666)
        assertThat(factorArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInEndTest() {
        factorArray.put(666, 3)
        assertThat(factorArray.get(0)).isEqualTo(1)
        assertThat(factorArray.get(1)).isEqualTo(2)
        assertThat(factorArray.get(2)).isEqualTo(3)
        assertThat(factorArray.get(3)).isEqualTo(666)
    }

    @Test
    fun delElementByIndexInBeginningTest() {
        val deleted = factorArray.del(0)
        assertThat(deleted).isEqualTo(1)
        assertThat(factorArray.get(0)).isEqualTo(2)
        assertThat(factorArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInMiddleTest() {
        val deleted = factorArray.del(1)
        assertThat(deleted).isEqualTo(2)
        assertThat(factorArray.get(0)).isEqualTo(1)
        assertThat(factorArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInEndTest() {
        val deleted = factorArray.del(2)
        assertThat(deleted).isEqualTo(3)
        assertThat(factorArray.get(0)).isEqualTo(1)
        assertThat(factorArray.get(1)).isEqualTo(2)
    }

    @Test
    fun toStringTest() {
        assertThat(factorArray.toString()).isEqualTo("[1, 2, 3]")
    }


    @Test
    fun delElementByOutOfBoundaryIndexTest() {
        assertThrows<IndexOutOfBoundsException> { factorArray.del(-1) }
        assertThrows<IndexOutOfBoundsException> { factorArray.del(3) }
        assertThrows<IndexOutOfBoundsException> { factorArray.del(3435435) }
    }
}