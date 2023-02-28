package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SingleArrayTest {
    private lateinit var singleArray: SingleArray<Int>

    @BeforeEach
    fun setUp() {
        singleArray = SingleArray()
        singleArray.put(1)
        singleArray.put(2)
        singleArray.put(3)
    }

    @Test
    fun putElementTest() {
        val sizeBefore = singleArray.size()

        singleArray.put(8)
        singleArray.put(50)
        singleArray.put(-60)
        val newSize = singleArray.size()

        assertThat(newSize).isEqualTo(sizeBefore + 3)
    }

    @Test
    fun getElementByIndexTest() {
        val actual = singleArray.get(1)

        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun isEmptyTest() {
        assertThat(singleArray.isEmpty()).isFalse()

        assertThat(SingleArray<Any>().isEmpty()).isTrue()
    }

    @Test
    fun putElementByIndexInBeginningTest() {
        singleArray.put(666, 0)
        assertThat(singleArray.get(0)).isEqualTo(666)
        assertThat(singleArray.get(1)).isEqualTo(1)
        assertThat(singleArray.get(2)).isEqualTo(2)
        assertThat(singleArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInMiddleTest() {
        singleArray.put(666, 2)
        assertThat(singleArray.get(0)).isEqualTo(1)
        assertThat(singleArray.get(1)).isEqualTo(2)
        assertThat(singleArray.get(2)).isEqualTo(666)
        assertThat(singleArray.get(3)).isEqualTo(3)
    }

    @Test
    fun putElementByIndexInEndTest() {
        singleArray.put(666, 3)
        assertThat(singleArray.get(0)).isEqualTo(1)
        assertThat(singleArray.get(1)).isEqualTo(2)
        assertThat(singleArray.get(2)).isEqualTo(3)
        assertThat(singleArray.get(3)).isEqualTo(666)
    }

    @Test
    fun delElementByIndexInBeginningTest() {
        val deleted = singleArray.del(0)
        assertThat(deleted).isEqualTo(1)
        assertThat(singleArray.get(0)).isEqualTo(2)
        assertThat(singleArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInMiddleTest() {
        val deleted = singleArray.del(1)
        assertThat(deleted).isEqualTo(2)
        assertThat(singleArray.get(0)).isEqualTo(1)
        assertThat(singleArray.get(1)).isEqualTo(3)
    }

    @Test
    fun delElementByIndexInEndTest() {
        val deleted = singleArray.del(2)
        assertThat(deleted).isEqualTo(3)
        assertThat(singleArray.get(0)).isEqualTo(1)
        assertThat(singleArray.get(1)).isEqualTo(2)
    }

    @Test
    fun toStringTest() {
        assertThat(singleArray.toString()).isEqualTo("[1, 2, 3]")
    }


    @Test
    fun name() {
        assertThrows<IndexOutOfBoundsException> { singleArray.del(-1) }
        assertThrows<IndexOutOfBoundsException> { singleArray.del(3) }
        assertThrows<IndexOutOfBoundsException> { singleArray.del(3435435) }
    }
}