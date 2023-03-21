package ru.geracimov.otus.algo.hw04

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows

class PriorityQueueImplTest {
    private lateinit var queue: PriorityQueueImpl<Int>

    @BeforeEach
    fun setUp() {
        queue = PriorityQueueImpl()
    }

    @Test
    fun enqueueDiffEqualityTest() {
        queue.enqueue(4, 4)
        queue.enqueue(3, 3)
        queue.enqueue(2, 2)
        queue.enqueue(1, 1)

        assertThat(queue.dequeue()).isEqualTo(1)
        assertThat(queue.dequeue()).isEqualTo(2)
        assertThat(queue.dequeue()).isEqualTo(3)
        assertThat(queue.dequeue()).isEqualTo(4)
    }

    @Test
    fun enqueueSamePriorityTest() {
        queue.enqueue(1, 10)
        queue.enqueue(1, 20)

        assertThat(queue.dequeue()).isEqualTo(10)
        assertThat(queue.dequeue()).isEqualTo(20)
    }

    @Test
    fun dequeueTest() {
        assertThrows<IllegalArgumentException> { queue.dequeue() }
    }
}