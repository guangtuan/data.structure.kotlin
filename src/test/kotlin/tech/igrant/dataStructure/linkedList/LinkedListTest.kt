package tech.igrant.dataStructure.linkedList

import org.junit.Assert.*
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
        assertEquals(2, list.remove(2)?.value)
        assertEquals("4", list.toString())
        assertEquals(4, list.remove(4)?.value)
        assertTrue(list.empty())
    }

    @Test
    fun cycle() {
        val head = Node(1, null)
        val node2 = Node(2, null)
        val node3 = Node(3, null)
        head.next = node2
        node2.next = node3
        node3.next = node2
        val list = LinkedList(head)
        assertTrue(list.cycle())

        val head2 = Node(1, Node(2, Node(3, Node(4, null))))
        val list2 = LinkedList(head2)
        assertFalse(list2.cycle())
    }

    @Test
    fun reverse() {
        val head = Node(1, Node(2, Node(3, Node(4, null))))
        val list = LinkedList(head)
        list.reverse()
        assertEquals("4321", list.toString())
        list.reverse()
        assertEquals("1234", list.toString())
    }

}