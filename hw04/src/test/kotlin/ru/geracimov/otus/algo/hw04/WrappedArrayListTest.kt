package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WrappedArrayListTest {
    private lateinit var array: WrappedArrayList<Int>

    @BeforeEach
    fun setUp() {
        array = WrappedArrayList()
        array.put(1)
        array.put(2)
        array.put(3)
    }

    @Test
    fun putElementTest() {
        val sizeBefore = array.size()

        array.put(8)
        array.put(50)
        array.put(-60)
        val newSize = array.size()

        assertThat(newSize).isEqualTo(sizeBefore + 3)
    }

    @Test
    fun getElementByIndexTest() {
        val actual = array.get(1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun isEmptyTest() {
        assertThat(array.isEmpty()).isFalse()

        assertThat(VectorArray<Any>().isEmpty()).isTrue()
    }

    @Test
    fun putElementByIndexInBeginningTest() {
        array.put(666, 0)
        assertThat(array.get(0)).isEqualTo(666)
        assertThat(array.get(1)).isEqualTo(1)
        assertThat(array.get(2)).isEqualTo(2)
        assertThat(array.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInMiddleTest() {
        array.put(666, 2)
        assertThat(array.get(0)).isEqualTo(1)
        assertThat(array.get(1)).isEqualTo(2)
        assertThat(array.get(2)).isEqualTo(666)
        assertThat(array.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInEndTest() {
        array.put(666, 3)
        assertThat(array.get(0)).isEqualTo(1)
        assertThat(array.get(1)).isEqualTo(2)
        assertThat(array.get(2)).isEqualTo(3)
        assertThat(array.get(3)).isEqualTo(666)
    }

    @Test
    fun delElementByIndexInBeginningTest() {
        val deleted = array.del(0)
        assertThat(deleted).isEqualTo(1)
        assertThat(array.get(0)).isEqualTo(2)
        assertThat(array.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInMiddleTest() {
        val deleted = array.del(1)
        assertThat(deleted).isEqualTo(2)
        assertThat(array.get(0)).isEqualTo(1)
        assertThat(array.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInEndTest() {
        val deleted = array.del(2)
        assertThat(deleted).isEqualTo(3)
        assertThat(array.get(0)).isEqualTo(1)
        assertThat(array.get(1)).isEqualTo(2)
    }

    @Test
    fun toStringTest() {
        assertThat(array.toString()).isEqualTo("[1, 2, 3]")
    }


    @Test
    fun delElementByOutOfBoundaryIndexTest() {
        assertThrows<IndexOutOfBoundsException> { array.del(-1) }
        assertThrows<IndexOutOfBoundsException> { array.del(3) }
        assertThrows<IndexOutOfBoundsException> { array.del(3435435) }
    }
}