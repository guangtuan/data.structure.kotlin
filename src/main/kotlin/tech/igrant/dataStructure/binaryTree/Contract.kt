package tech.igrant.dataStructure.binaryTree

interface Contract<T> {

    val height: Int
    val size: Int
    val isEmpty: Boolean
    val root: BinaryTreeNode<T>?
    fun getParent(node: BinaryTreeNode<T>): BinaryTreeNode<T>?
    fun getLeftChild(node: BinaryTreeNode<T>): BinaryTreeNode<T>?
    fun getRightChild(node: BinaryTreeNode<T>): BinaryTreeNode<T>?
    fun insert(item: T): Boolean
    fun remove(item: T): Boolean
    fun exists(item: T): BinaryTreeNode<T>?
    fun preOrder(treeNodeVisitor: TreeNodeVisitor<T>)
    fun inOrder(treeNodeVisitor: TreeNodeVisitor<T>)
    fun postOrder(treeNodeVisitor: TreeNodeVisitor<T>)
    fun levelOrder(treeNodeVisitor: TreeNodeVisitor<T>)

}