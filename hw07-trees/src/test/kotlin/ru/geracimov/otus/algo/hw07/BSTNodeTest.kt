package ru.geracimov.otus.algo.hw07

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import kotlin.random.Random

class BSTNodeTest {
    private lateinit var tree: BSTNode<Int, String>


    /**
     *             5
     *           /   \
     *          3     6
     *         / \
     *        2   4
     *       /
     *      1
     * */
    @BeforeEach
    fun setUp() {
        tree = BSTNode(5, "five")
        tree.insert(3, "three")
        tree.insert(4, "four")
        tree.insert(6, "six")
        tree.insert(2, "two")
        tree.insert(1, "one")
    }

    @Test
    fun insertNewValueTest() {
        assertThat(tree.search(7)).isNull()

        tree.insert(7, "seven")

        assertThat(tree.search(7)).isEqualTo("seven")
    }

    @Test
    fun insertExistsValueTest() {
        assertThat(tree.search(6)).isEqualTo("six")

        tree.insert(6, "six&six")

        assertThat(tree.search(6)).isEqualTo("six&six")
    }

    @Test
    fun searchTest() {
        assertThat(tree.search(6)).isEqualTo("six")
        assertThat(tree.search(5)).isEqualTo("five")
        assertThat(tree.search(1)).isEqualTo("one")
        assertThat(tree.search(0)).isNull()
        assertThat(tree.search(7)).isNull()
        assertThat(tree.search(Int.MAX_VALUE)).isNull()
        assertThat(tree.search(Int.MIN_VALUE)).isNull()
    }

    @Test
    fun removeExistsValueTest() {
        val removed = tree.remove(2)

        assertThat(tree.search(1)).isEqualTo("one")
        assertThat(tree.search(3)).isEqualTo("three")
        assertThat(tree.search(4)).isEqualTo("four")
        assertThat(tree.search(5)).isEqualTo("five")
        assertThat(tree.search(6)).isEqualTo("six")

        assertThat(removed).isEqualTo("two")
        assertThat(tree.search(2)).isNull()
    }

    @Test
    fun removeEmptyValueTest() {
        val removed = tree.remove(7)

        assertThat(tree.search(1)).isEqualTo("one")
        assertThat(tree.search(2)).isEqualTo("two")
        assertThat(tree.search(3)).isEqualTo("three")
        assertThat(tree.search(4)).isEqualTo("four")
        assertThat(tree.search(5)).isEqualTo("five")
        assertThat(tree.search(6)).isEqualTo("six")

        assertThat(removed).isNull()
    }

    @Test
    fun treeTestRandomValue() {
        val root = BSTNode(0, "root")
        test(root, 200000) { _, limit -> Random.nextInt(limit) }
    }

    @Test
    fun treeTestOrderedValue() {
        val root = BSTNode(0, "root")
        test(root, 200000) { i, _ -> i }
    }

    private fun test(tree: Tree<Int, String>, limit: Int, generator: (Int, Int) -> Int) {

        for (i in 1..limit) {
            val int = generator.invoke(i, limit)
            tree.insert(int, int.toString())
        }

        for (i in 1..10) {
            val int = Random.nextInt(limit)
            tree.search(int)
        }

        for (i in 1..10) {
            val int = Random.nextInt(limit)
            tree.remove(int)
        }
    }
}