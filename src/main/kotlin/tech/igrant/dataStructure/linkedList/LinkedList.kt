package tech.igrant.dataStructure.linkedList

class LinkedList<T>(private var head: Node<T>?) : Contract<T> {

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
                        return it
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

    override fun cycle(): Boolean {
        var slow :Node<T>?
        var fast: Node<T>?
        if (head?.next == null) {
            return false
        }
        slow = head
        fast = head?.next
        while (slow != fast) {
            if (fast?.next == null) {
                return false
            }
            slow = slow?.next
            fast = fast.next?.next
        }
        return true
    }

    override fun reverse() {
        var curr: Node<T>?
        var next: Node<T>?
        var pre: Node<T>? = null
        curr = head
        while (curr != null) {
            next = curr.next
            curr.next = pre
            pre = curr
            curr = next
        }
        head = pre
    }
}