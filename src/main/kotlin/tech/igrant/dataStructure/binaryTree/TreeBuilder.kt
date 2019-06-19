package tech.igrant.dataStructure.binaryTree

/**
 * build a bst from a sorted list
 */
fun fromSortedArray(sortedArray: Array<Int>): BinaryTree<Int> {
    return BinaryTree(subTree(sortedArray, 0, sortedArray.size - 1))
}

fun subTree(sortedArray: Array<Int>, left: Int, right: Int): Node<Int>? {
    if (left > right) {
        return null
    }
    val middle = left + (right - left) / 2
    val rootValue = sortedArray[middle]
    return Node(
        data = rootValue,
        lc = subTree(sortedArray, left, middle - 1),
        rc = subTree(sortedArray, middle + 1, right)
    )
}

fun buildFromPreOrderAndInOrder(preOrder: Array<Int>, inOrder: Array<Int>): BinaryTree<Int> {
    if (preOrder.size != inOrder.size) {
        return BinaryTree(null)
    }

    val loopUp = inOrder.foldIndexed(mutableMapOf<Int, Int>(), { idx, acc, i ->
        acc[i] = idx
        return@foldIndexed acc
    })
    fun buildNode(preOrder: Array<Int>, inOrder: Array<Int>, preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): Node<Int>? {
        if (preStart > preEnd || inStart > inEnd) {
            return null
        }
        val rootValue = preOrder[preStart]
        var rootIndexAtInOrder = -1
        loopUp[rootValue]?.let {
            rootIndexAtInOrder = it
        }
        if (rootIndexAtInOrder == -1) {
            return null
        }
        val leftTreeSize = rootIndexAtInOrder - inStart
        val rightTreeSize = inEnd - rootIndexAtInOrder
        return Node(
            data = rootValue,
            lc = buildNode(preOrder, inOrder, preStart + 1, preStart + leftTreeSize, inStart, rootIndexAtInOrder - 1),
            rc = buildNode(preOrder, inOrder, preEnd - rightTreeSize + 1, preEnd, rootIndexAtInOrder + 1, inEnd)
        )
    }

    val node = buildNode(preOrder, inOrder, 0, preOrder.size - 1, 0, inOrder.size - 1)
    return BinaryTree(node)
}