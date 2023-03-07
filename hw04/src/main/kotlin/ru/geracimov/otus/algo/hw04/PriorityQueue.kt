package ru.geracimov.otus.algo.hw04

import kotlin.collections.Iterator

interface PriorityQueue<T> {

    fun enqueue(priority: Int, item: T)
    fun dequeue(): T

}


class PriorityQueueImpl<T> : PriorityQueue<T> {
    private val head: LinkedNode<T> = LinkedNode(null, Int.MAX_VALUE)
    private var tail: LinkedNode<T> = head

    override fun enqueue(priority: Int, item: T) {
        val newElement = LinkedNode(item, priority)

        val morePriorElement = head.firstOrNull { it.priority <= priority }

        if (morePriorElement == null) {
            tail.next = newElement
            newElement.prev = tail
            tail = newElement
        } else {
            newElement.insertBefore(morePriorElement)
        }
    }

    override fun dequeue(): T {
        if (tail == head) {
            throw IllegalArgumentException("PriorityQueue is empty")
        }
        val value: T = tail.value!!
        tail = tail.prev!!
        tail.next = null
        return value
    }

    override fun toString(): String {
        return head.joinToString { it.toString() }
    }

    private class LinkedNode<T>(val value: T?, val priority: Int) : Iterable<LinkedNode<T>> {
        var next: LinkedNode<T>? = null
        var prev: LinkedNode<T>? = null

        fun insertBefore(node: LinkedNode<T>) {
            val prev = node.prev
            prev?.next = this
            this.next = node
            this.prev = prev
            node.prev = this
        }

        override fun iterator(): Iterator<LinkedNode<T>> {
            return LinkedNodeIterator(this)
        }

        override fun toString(): String {
            return if (prev == null) "HEAD" else "$value ($priority)"
        }

        private class LinkedNodeIterator<T>(private val node: LinkedNode<T>) : Iterator<LinkedNode<T>> {
            private var current: LinkedNode<T> = node

            override fun next(): LinkedNode<T> {
                current = current.next!!
                return current
            }

            override fun hasNext(): Boolean {
                return current.next != null
            }
        }
    }

}