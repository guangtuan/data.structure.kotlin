package tech.igrant.dataStructure.binaryTree

import java.util.LinkedList

/**
 * build a bst from a sorted list
 */
fun fromSortedArray(sortedList: LinkedList<Int>): BinaryTree<Int> {
    val sortedArray = sortedList.toTypedArray()
    val root = subTree(sortedArray, 0, sortedArray.size - 1)
    return BinaryTree(root)
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