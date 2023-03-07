package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MatrixArrayTest {
    private lateinit var matrixArray: MatrixArray<Int>

    @BeforeEach
    fun setUp() {
        matrixArray = MatrixArray(2)
        matrixArray.put(1)
        matrixArray.put(2)
        matrixArray.put(3)
    }

    @Test
    fun putElementTest() {
        val sizeBefore = matrixArray.size()

        matrixArray.put(8)
        matrixArray.put(50)
        matrixArray.put(-60)
        val newSize = matrixArray.size()

        assertThat(newSize).isEqualTo(sizeBefore + 3)
    }

    @Test
    fun getElementByIndexTest() {
        val actual = matrixArray.get(1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun isEmptyTest() {
        assertThat(matrixArray.isEmpty()).isFalse()

        assertThat(VectorArray<Any>().isEmpty()).isTrue()
    }

    @Test
    fun putElementByIndexInBeginningTest() {
        matrixArray.put(666, 0)
        assertThat(matrixArray.get(0)).isEqualTo(666)
        assertThat(matrixArray.get(1)).isEqualTo(1)
        assertThat(matrixArray.get(2)).isEqualTo(2)
        assertThat(matrixArray.get(3)).isEqualTo(3)
        assertThat(matrixArray.size()).isEqualTo(4)
    }

    @Test
    fun putElementByIndexInMiddleTest() {
        matrixArray.put(666, 2)
        assertThat(matrixArray.get(0)).isEqualTo(1)
        assertThat(matrixArray.get(1)).isEqualTo(2)
        assertThat(matrixArray.get(2)).isEqualTo(666)
        assertThat(matrixArray.get(3)).isEqualTo(3)
        assertThat(matrixArray.size()).isEqualTo(4)
    }

    @Test
    fun putElementByIndexInEndTest() {
        matrixArray.put(666, 3)
        assertThat(matrixArray.get(0)).isEqualTo(1)
        assertThat(matrixArray.get(1)).isEqualTo(2)
        assertThat(matrixArray.get(2)).isEqualTo(3)
        assertThat(matrixArray.get(3)).isEqualTo(666)
        assertThat(matrixArray.size()).isEqualTo(4)
    }

    @Test
    fun delElementByIndexInBeginningTest() {
        val deleted = matrixArray.del(0)
        assertThat(deleted).isEqualTo(1)
        assertThat(matrixArray.get(0)).isEqualTo(2)
        assertThat(matrixArray.get(1)).isEqualTo(3)
        assertThat(matrixArray.size()).isEqualTo(2)
    }

    @Test
    fun delElementByIndexInMiddleTest() {
        val deleted = matrixArray.del(1)
        assertThat(deleted).isEqualTo(2)
        assertThat(matrixArray.get(0)).isEqualTo(1)
        assertThat(matrixArray.get(1)).isEqualTo(3)
        assertThat(matrixArray.size()).isEqualTo(2)
    }

    @Test
    fun delElementByIndexInEndTest() {
        val deleted = matrixArray.del(2)
        assertThat(deleted).isEqualTo(3)
        assertThat(matrixArray.get(0)).isEqualTo(1)
        assertThat(matrixArray.get(1)).isEqualTo(2)
        assertThat(matrixArray.size()).isEqualTo(2)
    }

    @Test
    fun toStringTest() {
        assertThat(matrixArray.toString()).isEqualTo("[1, 2, 3]")
    }


    @Test
    fun delElementByOutOfBoundaryIndexTest() {
        assertThrows<IndexOutOfBoundsException> { matrixArray.del(-1) }
        assertThrows<IndexOutOfBoundsException> { matrixArray.del(3) }
        assertThrows<IndexOutOfBoundsException> { matrixArray.del(3435435) }
    }
}