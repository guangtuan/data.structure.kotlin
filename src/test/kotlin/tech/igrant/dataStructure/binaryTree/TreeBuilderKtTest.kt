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
        list.add(0)
        list.add(5)
        list.add(9)
        val tree = fromSortedArray(list)
        val collect = LinkedList<Int>()
        tree.inOrderTraversal(object : TreeNodeVisitor<Int> {
            override fun visit(t: Node<Int>) {
                collect.add(t.data)
            }
        })
        Assert.assertArrayEquals(collect.toTypedArray(), list.toTypedArray())
    }
}