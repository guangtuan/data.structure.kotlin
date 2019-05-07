package tech.igrant.dataStructure.linkedList

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LinkedListTest {

    @Test
    fun testSearch() {
        val head = Node(1, Node(2, Node(3, Node(4, null))))
        val list = LinkedList(head)
        assert(list.search(3)?.value == 3)
        assert(list.search(4)?.value == 4)
        assert(list.search(5) == null)
    }

    @Test
    fun insert() {
        val head = Node(1, Node(2, Node(3, Node(4, null))))
        val list = LinkedList(head)
        assert(list.insert(4, Node(5, null)))
        assert(list.toString() == "12345")
        assert(list.insert(4, Node(6, null)))
        assert(list.toString() == "123465")
        assert(!list.insert(10, Node(6, null)))
    }

    @Test
    fun remove() {
        val head = Node(1, Node(2, Node(3, Node(4, null))))
        val list = LinkedList(head)
        assertEquals(3, list.remove(3)?.value)
        assertEquals("124", list.toString())
        assertNull(list.remove(5))
        assertEquals(1, list.remove(1)?.value)
        assertEquals("24", list.toString())
    }

}