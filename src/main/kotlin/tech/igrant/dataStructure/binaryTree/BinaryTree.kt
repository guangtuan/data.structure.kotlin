package tech.igrant.dataStructure.binaryTree

class BinaryTree<T>(override val root: BinaryTreeNode<T>?) : Contract<T> {

    private fun getHeight(level: Int, node: BinaryTreeNode<T>): Int {
        node.lc?.let {
            node.rc?.let {
                val leftHeight = getHeight(level + 1, node.lc)
                val rightHeight = getHeight(level + 1, node.rc)
                return Math.max(leftHeight, rightHeight)
            }
            return getHeight(level + 1, node.lc)
        }
        node.rc?.let {
            return getHeight(level + 1, node.rc)
        }
        return level
    }

    private fun getSize(size: Int, root: BinaryTreeNode<T>): Int {
        root.lc?.let {
            root.rc?.let {
                return size + getSize(1, root.lc) + getSize(1, root.rc)
            }
            return size + getSize(1, root.lc)
        }
        root.rc?.let {
            return size + getSize(1, root.rc)
        }
        return size
    }

    override val height: Int
        get() = if (root == null) {
            0
        } else {
            getHeight(1, this.root)
        }

    override val size: Int
        get() = if (root == null) {
            0
        } else {
            getSize(1, this.root)
        }

    override val isEmpty: Boolean
        get() = this.root == null

    override fun getParent(node: BinaryTreeNode<T>): BinaryTreeNode<T>? {
        return null
    }

    override fun getLeftChild(node: BinaryTreeNode<T>): BinaryTreeNode<T>? {
        return null
    }

    override fun getRightChild(node: BinaryTreeNode<T>): BinaryTreeNode<T>? {
        return null
    }

    override fun insert(item: T): Boolean {
        return false
    }

    override fun remove(item: T): Boolean {
        return false
    }

    override fun exists(item: T): BinaryTreeNode<T>? {
        return null
    }

    override fun preOrder(treeNodeVisitor: TreeNodeVisitor<T>) {

    }

    override fun inOrder(treeNodeVisitor: TreeNodeVisitor<T>) {

    }

    override fun postOrder(treeNodeVisitor: TreeNodeVisitor<T>) {

    }

    override fun levelOrder(treeNodeVisitor: TreeNodeVisitor<T>) {

    }

}