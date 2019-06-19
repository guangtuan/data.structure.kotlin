package tech.igrant.dataStructure.binaryTree

import org.junit.Test
import java.util.*
import org.junit.Assert.assertArrayEquals

class TreeBuilderKtTest {

    @Test
    fun fromSortedArray() {
        val list = LinkedList<Int>()
        list.add(-10)
        list.add(-3)
        list.add(-1)
        list.add(0)
        list.add(5)
        list.add(9)
        list.add(15)
        val tree = fromSortedArray(list.toTypedArray())
        val collect = LinkedList<Int>()
        tree.inOrderTraversal(object : TreeNodeVisitor<Int> {
            override fun visit(t: Node<Int>) {
                collect.add(t.data)
            }
        })
        assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
    }

    @Test
    fun fromSortedArray2() {
        val list = LinkedList<Int>()
        list.add(-10)
        val tree = fromSortedArray(list.toTypedArray())
        val collect = LinkedList<Int>()
        tree.inOrderTraversal(object : TreeNodeVisitor<Int> {
            override fun visit(t: Node<Int>) {
                collect.add(t.data)
            }
        })
        assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
    }


    @Test
    fun fromSortedArray3() {
        val list = LinkedList<Int>()
        val tree = fromSortedArray(list.toTypedArray())
        val collect = LinkedList<Int>()
        tree.inOrderTraversal(object : TreeNodeVisitor<Int> {
            override fun visit(t: Node<Int>) {
                collect.add(t.data)
            }
        })
        assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
    }

    @Test
    fun buildFromPreOrderAndInOrder() {

        val preOrder = arrayOf(1, 2, 4, 7, 3, 5, 6, 8)
        val inOrder = arrayOf(4, 7, 2, 1, 5, 3, 8, 6)
        val tree = buildFromPreOrderAndInOrder(preOrder, inOrder)

        val collector = object : TreeNodeVisitor<Int> {
            val arr = arrayListOf<Int>()
            override fun visit(t: Node<Int>) {
                arr.add(t.data)
            }
        }
        tree.preOrderTraversal(collector)
        assertArrayEquals(preOrder, collector.arr.toArray())
        collector.arr.clear()
        tree.inOrderTraversal(collector)
        assertArrayEquals(inOrder, collector.arr.toArray())
    }

}