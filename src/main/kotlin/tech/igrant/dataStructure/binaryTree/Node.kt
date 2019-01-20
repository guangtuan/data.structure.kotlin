package tech.igrant.dataStructure.binaryTree

class Node<T>(val data: T, val lc: Node<T>?, val rc: Node<T>?) {
    constructor(data: T) : this(data, null, null)

    override fun toString(): String {
        return data.toString()
    }
}