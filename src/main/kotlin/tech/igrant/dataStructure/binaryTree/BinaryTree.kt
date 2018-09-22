package tech.igrant.dataStructure.binaryTree

class BinaryTree<T>(override val root: Node<T>?) : Contract<T> {

    private fun getHeight(level: Int, node: Node<T>): Int {
        node.lc?.let {
            node.rc?.let {
                val leftHeight = getHeight(level + 1, it@node.lc)
                val rightHeight = getHeight(level + 1, it@node.rc)
                return Math.max(leftHeight, rightHeight)
            }
            return getHeight(level + 1, it@node.lc)
        }
        node.rc?.let {
            return getHeight(level + 1, it)
        }
        return level
    }

    private fun getSize(size: Int, root: Node<T>): Int {
        root.lc?.let {
            root.rc?.let {
                return size + getSize(1, it@root.lc) + getSize(1, it@root.rc)
            }
            return size + getSize(1, it@root.lc)
        }
        root.rc?.let {
            return size + getSize(1, it@root.rc)
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

    override fun insert(item: T): Boolean {
        return false
    }

    override fun remove(item: T): Boolean {
        return false
    }

    override fun exists(item: T): Node<T>? {
        return null
    }

    private fun preOrderWalk(root: Node<T>, treeNodeVisitor: TreeNodeVisitor<T>) {
        treeNodeVisitor.visit(root)
        root.lc?.let {
            preOrderWalk(it, treeNodeVisitor)
        }
        root.rc?.let {
            preOrderWalk(it, treeNodeVisitor)
        }
    }

    override fun preOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>) {
        this.root?.let {
            preOrderWalk(it, treeNodeVisitor)
        }
    }

    private fun inOrderWalk(root: Node<T>, treeNodeVisitor: TreeNodeVisitor<T>) {
        root.lc?.let {
            inOrderWalk(it, treeNodeVisitor)
        }
        treeNodeVisitor.visit(root)
        root.rc?.let {
            inOrderWalk(it, treeNodeVisitor)
        }
    }

    override fun inOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>) {
        this.root?.let {
            inOrderWalk(it, treeNodeVisitor)
        }
    }

    private fun postOrderWalk(root: Node<T>, treeNodeVisitor: TreeNodeVisitor<T>) {
        root.lc?.let {
            postOrderWalk(it, treeNodeVisitor)
        }
        root.rc?.let {
            postOrderWalk(it, treeNodeVisitor)
        }
        treeNodeVisitor.visit(root)
    }

    override fun postOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>) {
        this.root?.let {
            postOrderWalk(it, treeNodeVisitor)
        }
    }

    private fun levelOrderWalk(list: ArrayList<Node<T>>, treeNodeVisitor: TreeNodeVisitor<T>) {
        val nextList = arrayListOf<Node<T>>()
        list.forEach {
            treeNodeVisitor.visit(it)
            it.lc?.let {
                nextList.add(it)
            }
            it.rc?.let {
                nextList.add(it)
            }
        }
        if (nextList.size != 0) {
            levelOrderWalk(nextList, treeNodeVisitor)
        }
    }

    override fun levelOrderTraversal(treeNodeVisitor: TreeNodeVisitor<T>) {
        this.root?.let {
            levelOrderWalk(arrayListOf(it), treeNodeVisitor)
        }
    }

}