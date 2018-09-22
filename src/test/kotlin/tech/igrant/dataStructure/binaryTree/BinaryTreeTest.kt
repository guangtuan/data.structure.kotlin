package tech.igrant.dataStructure.binaryTree

import org.junit.Test
import org.junit.Assert

class BinaryTreeTest {

    @Test
    fun getHeight() {
        assert(BinaryTree<Int>(null).height == 0)

        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3,
                    lc = null,
                    rc = null),
                rc = null
            ),
            rc = Node(
                data = 4,
                lc = null,
                rc = Node(
                    data = 5,
                    lc = null,
                    rc = Node(
                        data = 7,
                        lc = Node(
                            data = 10,
                            lc = null,
                            rc = null
                        ),
                        rc = null
                    )
                )
            )
        ))
        assert(tree.height == 5)
    }

    @Test
    fun getSize() {
        assert(BinaryTree<Int>(null).size == 0)

        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3,
                    lc = null,
                    rc = null),
                rc = null
            ),
            rc = Node(
                data = 4,
                lc = null,
                rc = Node(
                    data = 5,
                    lc = null,
                    rc = Node(
                        data = 7,
                        lc = Node(
                            data = 10,
                            lc = null,
                            rc = null
                        ),
                        rc = null
                    )
                )
            )
        ))
        assert(tree.size == 7)
    }

    @Test
    fun isEmpty() {
        assert(BinaryTree<Int>(null).isEmpty)

        assert(!BinaryTree(
            Node(
                data = 1,
                lc = null,
                rc = null
            )
        ).isEmpty)
    }

    @Test
    fun preOrderTraversal() {
        val collector = object : TreeNodeVisitor<Int> {
            val arr = arrayListOf<Int>()

            override fun visit(t: Node<Int>) {
                arr.add(t.data)
            }
        }
        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3,
                    lc = null,
                    rc = null),
                rc = null
            ),
            rc = Node(
                data = 4,
                lc = null,
                rc = Node(
                    data = 5,
                    lc = null,
                    rc = Node(
                        data = 7,
                        lc = Node(
                            data = 10,
                            lc = null,
                            rc = null
                        ),
                        rc = null
                    )
                )
            )
        ))
        tree.preOrderTraversal(collector)
        val expectResult = arrayListOf(1, 2, 3, 4, 5, 7, 10)
        for ((index, value) in expectResult.withIndex()) {
            Assert.assertEquals(value, collector.arr[index])
        }
    }

    @Test
    fun inOrderTraversal() {
        val collector = object: TreeNodeVisitor<Int> {
            val arr = arrayListOf<Int>()
            override fun visit(t: Node<Int>) {
                arr.add(t.data)
            }
        }
        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3
                ),
                rc = Node(
                    data = 4
                )
            ),
            rc = Node(
                data = 5,
                lc = Node(
                    data = 6
                ),
                rc = Node(
                    data = 7
                )
            )
        ))
        tree.inOrderTraversal(collector)
        val expectedResult = arrayListOf(3, 2, 4, 1, 6, 5, 7)
        for ((index, value) in expectedResult.withIndex()) {
            Assert.assertEquals(value, collector.arr[index])
        }
    }

    @Test
    fun postOrderTraversal() {
        val collector = object: TreeNodeVisitor<Int> {
            val arr = arrayListOf<Int>()
            override fun visit(t: Node<Int>) {
                arr.add(t.data)
            }
        }
        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3
                ),
                rc = Node(
                    data = 4
                )
            ),
            rc = Node(
                data = 5,
                lc = Node(
                    data = 6
                ),
                rc = Node(
                    data = 7
                )
            )
        ))
        tree.postOrderTraversal(collector)
        val expectedResult = arrayListOf(3, 4, 2, 6, 7, 5, 1)
        for ((index, value) in expectedResult.withIndex()) {
            Assert.assertEquals(value, collector.arr[index])
        }
    }

    @Test
    fun levelOrderTraversal() {
        val collector = object: TreeNodeVisitor<Int> {
            val arr = arrayListOf<Int>()
            override fun visit(t: Node<Int>) {
                arr.add(t.data)
            }
        }
        val tree = BinaryTree(Node(
            data = 1,
            lc = Node(
                data = 2,
                lc = Node(
                    data = 3
                ),
                rc = Node(
                    data = 4
                )
            ),
            rc = Node(
                data = 5,
                lc = Node(
                    data = 6
                ),
                rc = Node(
                    data = 7
                )
            )
        ))
        tree.levelOrderTraversal(collector)
        val expectedResult = arrayListOf(1, 2, 5, 3, 4, 6, 7)
        for ((index, value) in expectedResult.withIndex()) {
            Assert.assertEquals(value, collector.arr[index])
        }
    }

}