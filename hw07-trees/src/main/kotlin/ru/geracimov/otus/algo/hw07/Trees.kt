package ru.geracimov.otus.algo.hw07

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
        insertIterative(this, key, value)
    }

    private fun insertRecursive(key: K, value: V) {
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

    private fun insertIterative(root: BSTNode<K, V>?, key: K, value: V) {
        var search = root
        while (search != null) {
            if (search.key == key) {
                search.value = value
                return
            }

            if (key < search.key) {
                if (search.left == null) {
                    search.left = BSTNode(key, value, search)
                    break
                }
                search = search.left
            } else {
                if (search.right == null) {
                    search.right = BSTNode(key, value, search)
                    break
                }
                search = search.right
            }
        }
    }

    override fun search(key: K): V? {
        return searchIterative(this, key)?.value
    }

    private fun searchRecursive(root: BSTNode<K, V>?, key: K): BSTNode<K, V>? {
        if (root == null) return null
        if (root.key == key) return root
        if (key < root.key) {
            val found = root.left?.let { searchRecursive(it, key) }
            if (found != null) {
                return found
            }
        } else {
            val found = root.right?.let { searchRecursive(it, key) }
            if (found != null) {
                return found
            }
        }
        return null
    }

    private fun searchIterative(root: BSTNode<K, V>?, key: K): BSTNode<K, V>? {
        var search = root
        while (search != null && search.key != key) {
            search = if (key < search.key) {
                search.left
            } else {
                search.right
            }
        }
        return search
    }

    override fun remove(key: K): V? {
        val found = searchIterative(this, key) ?: return null

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

}
