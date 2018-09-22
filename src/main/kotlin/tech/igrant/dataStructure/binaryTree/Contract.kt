package tech.igrant.dataStructure.binaryTree

interface Contract<T> {

    val height: Int
    val size: Int
    val isEmpty: Boolean
    val root: Node<T>?
    fun insert(item: T): Boolean
    fun remove(item: T): Boolean
    fun exists(item: T): Node<T>?
    fun preOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun inOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun postOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)
    fun levelOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>)

}