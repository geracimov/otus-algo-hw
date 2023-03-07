package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class VectorArrayTest {
    private lateinit var vectorArray: VectorArray<Int>

    @BeforeEach
    fun setUp() {
        vectorArray = VectorArray()
        vectorArray.put(1)
        vectorArray.put(2)
        vectorArray.put(3)
    }

    @Test
    fun putElementTest() {
        val sizeBefore = vectorArray.size()

        vectorArray.put(8)
        vectorArray.put(50)
        vectorArray.put(-60)
        val newSize = vectorArray.size()

        assertThat(newSize).isEqualTo(sizeBefore + 3)
    }

    @Test
    fun getElementByIndexTest() {
        val actual = vectorArray.get(1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun isEmptyTest() {
        assertThat(vectorArray.isEmpty()).isFalse()

        assertThat(VectorArray<Any>().isEmpty()).isTrue()
    }

    @Test
    fun putElementByIndexInBeginningTest() {
        vectorArray.put(666, 0)
        assertThat(vectorArray.get(0)).isEqualTo(666)
        assertThat(vectorArray.get(1)).isEqualTo(1)
        assertThat(vectorArray.get(2)).isEqualTo(2)
        assertThat(vectorArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInMiddleTest() {
        vectorArray.put(666, 2)
        assertThat(vectorArray.get(0)).isEqualTo(1)
        assertThat(vectorArray.get(1)).isEqualTo(2)
        assertThat(vectorArray.get(2)).isEqualTo(666)
        assertThat(vectorArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInEndTest() {
        vectorArray.put(666, 3)
        assertThat(vectorArray.get(0)).isEqualTo(1)
        assertThat(vectorArray.get(1)).isEqualTo(2)
        assertThat(vectorArray.get(2)).isEqualTo(3)
        assertThat(vectorArray.get(3)).isEqualTo(666)
    }

    @Test
    fun delElementByIndexInBeginningTest() {
        val deleted = vectorArray.del(0)
        assertThat(deleted).isEqualTo(1)
        assertThat(vectorArray.get(0)).isEqualTo(2)
        assertThat(vectorArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInMiddleTest() {
        val deleted = vectorArray.del(1)
        assertThat(deleted).isEqualTo(2)
        assertThat(vectorArray.get(0)).isEqualTo(1)
        assertThat(vectorArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInEndTest() {
        val deleted = vectorArray.del(2)
        assertThat(deleted).isEqualTo(3)
        assertThat(vectorArray.get(0)).isEqualTo(1)
        assertThat(vectorArray.get(1)).isEqualTo(2)
    }

    @Test
    fun toStringTest() {
        assertThat(vectorArray.toString()).isEqualTo("[1, 2, 3]")
    }


    @Test
    fun delElementByOutOfBoundaryIndexTest() {
        assertThrows<IndexOutOfBoundsException> { vectorArray.del(-1) }
        assertThrows<IndexOutOfBoundsException> { vectorArray.del(3) }
        assertThrows<IndexOutOfBoundsException> { vectorArray.del(3435435) }
    }
}