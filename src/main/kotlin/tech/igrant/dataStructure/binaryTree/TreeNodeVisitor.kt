package tech.igrant.dataStructure.binaryTree

interface TreeNodeVisitor<T> {
    fun visit(t: BinaryTreeNode<T>)
}