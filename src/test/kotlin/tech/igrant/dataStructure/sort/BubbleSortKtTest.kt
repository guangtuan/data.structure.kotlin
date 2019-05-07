package tech.igrant.dataStructure.sort

import org.junit.Test

import org.junit.Assert.*

class BubbleSortKtTest {

    @Test
    fun bubbleSort() {
        val input = arrayOf(5, 8, 2, 3, 1)
        bubbleSort(input)
        assertEquals("8, 5, 3, 2, 1", input.joinToString {  i -> i.toString() })
    }

}