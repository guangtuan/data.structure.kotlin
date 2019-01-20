package tech.igrant.dataStructure.binaryTree

interface Contract<T> {

    val height: Int
    val size: Int
    val isEmpty: Boolean
    val root: Node<T>?
    fun preOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun inOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun postOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun levelOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)

    fun inOrderWithoutRecursive(treeNodeVisitor: TreeNodeVisitor<T>)
}