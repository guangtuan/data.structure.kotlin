package tech.igrant.dataStructure.binaryTree

import org.junit.Test

class BinaryTreeTest {

    @Test
    fun getHeight() {
        assert(BinaryTree<Int>(null).height == 0)

        val tree = BinaryTree(
            BinaryTreeNode(
                data = 1,
                lc = BinaryTreeNode(
                    data = 2,
                    lc = BinaryTreeNode(
                        data = 3,
                        lc = null,
                        rc = null),
                    rc = null
                ),
                rc = BinaryTreeNode(
                    data = 4,
                    lc = null,
                    rc = BinaryTreeNode(
                        data = 5,
                        lc = null,
                        rc = BinaryTreeNode(
                            data = 7,
                            lc = BinaryTreeNode(
                                data = 10,
                                lc = null,
                                rc = null
                            ),
                            rc = null
                        )
                    )
                )
            )
        )
        assert(tree.height == 5)
    }

    @Test
    fun getSize() {
        assert(BinaryTree<Int>(null).size == 0)

        val tree = BinaryTree(
            BinaryTreeNode(
                data = 1,
                lc = BinaryTreeNode(
                    data = 2,
                    lc = BinaryTreeNode(
                        data = 3,
                        lc = null,
                        rc = null),
                    rc = null
                ),
                rc = BinaryTreeNode(
                    data = 4,
                    lc = null,
                    rc = BinaryTreeNode(
                        data = 5,
                        lc = null,
                        rc = BinaryTreeNode(
                            data = 7,
                            lc = BinaryTreeNode(
                                data = 10,
                                lc = null,
                                rc = null
                            ),
                            rc = null
                        )
                    )
                )
            )
        )
        assert(tree.size == 7)
    }

    @Test
    fun isEmpty() {
        assert(BinaryTree<Int>(null).isEmpty)

        assert(!BinaryTree(
            BinaryTreeNode(
                data = 1,
                lc = null,
                rc = null
            )
        ).isEmpty);
    }
}