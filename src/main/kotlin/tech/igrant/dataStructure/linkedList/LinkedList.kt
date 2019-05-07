package tech.igrant.dataStructure.linkedList

class LinkedList<T>(var head: Node<T>?) : Contract<T> {

    override fun search(value: T): Node<T>? {
        if (head?.value == value) {
            return head
        }
        var cursor = head?.next
        while (cursor != null) {
            if (cursor.value == value) {
                return cursor
            }
            cursor = cursor.next
        }
        return null
    }

    override fun insert(value: T, toInsert: Node<T>): Boolean {
        val pre = search(value)
        pre?.let {
            toInsert.next = pre.next
            pre.next = toInsert
            return true
        }
        return false
    }

    private fun searchPre(value: T): Node<T>? {
        var cursor = head
        while (true) {
            cursor?.let {
                it.next?.let { it1 ->
                    if (it1.value == value) {
                        return it;
                    }
                    cursor = it1
                }
            } ?: run {
                return null
            }
        }
    }

    override fun remove(value: T): Node<T>? {
        head?.let {
            if (it.value == value) {
                val ret = it
                head = it.next
                return ret
            }
        } ?: run {
            return null
        }
        val preOfToRemove = searchPre(value)
        var ret: Node<T>? = null
        preOfToRemove?.let {
            ret = it.next
            it.next = it.next?.next
        }
        return ret
    }

    override fun empty(): Boolean {
        return head == null
    }

    override fun toString(): String {
        var toString = "${head?.value}"
        var cursor = head?.next
        while (cursor != null) {
            toString = "$toString${cursor.value}"
            cursor = cursor.next
        }
        return toString
    }
}