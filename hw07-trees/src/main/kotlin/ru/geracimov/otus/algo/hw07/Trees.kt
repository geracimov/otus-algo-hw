package ru.geracimov.otus.algo.hw07

import kotlin.math.max

interface Tree<K : Comparable<K>, V> {
    fun insert(key: K, value: V)
    fun search(key: K): V?
    fun remove(key: K): V?
}


class BSTNode<K : Comparable<K>, V>(
    private var key: K,
    private var value: V,
    private var parent: BSTNode<K, V>? = null
) : Tree<K, V> {
    private var left: BSTNode<K, V>? = null
    private var right: BSTNode<K, V>? = null

    override fun insert(key: K, value: V) {
        if (this.key == key) {
            this.value = value
            return
        }
        if (key < this.key) {
            if (left == null) {
                left = BSTNode(key, value, this)
            } else {
                left!!.insert(key, value)
            }
        } else {
            if (right == null) {
                right = BSTNode(key, value, this)
            } else {
                right!!.insert(key, value)
            }
        }
    }

    override fun search(key: K): V? {
        return search(this, key)?.value
    }

    private fun search(root: BSTNode<K, V>?, key: K): BSTNode<K, V>? {
        if (root == null) return null
        if (root.key == key) return root
        if (key < root.key) {
            val found = root.left?.let { search(it, key) }
            if (found != null) {
                return found
            }
        } else {
            val found = root.right?.let { search(it, key) }
            if (found != null) {
                return found
            }
        }
        return null
    }

    override fun remove(key: K): V? {
        val found = search(this, key) ?: return null

        with(found) {
            if (left == null && right == null) {
                if (parent?.left == this)
                    parent?.left = null
                else
                    parent?.right = null
            } else {
                if (parent?.left == this)
                    parent?.left = left
                else
                    parent?.right = right
            }
        }
        return found.value
    }

    override fun toString(): String {
        return "$key(${getHeight()})"
    }

    private fun getHeight(): Int {
        return max(left?.getHeight() ?: 0, right?.getHeight() ?: 0) + 1
    }

}
