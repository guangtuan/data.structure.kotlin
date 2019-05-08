package tech.igrant.dataStructure.binaryTree

import org.junit.Assert
import org.junit.Test
import java.util.*

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
        Assert.assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
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
        Assert.assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
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
        Assert.assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
    }
}