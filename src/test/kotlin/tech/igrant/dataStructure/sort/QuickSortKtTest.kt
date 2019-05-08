package tech.igrant.dataStructure.sort

import org.junit.Assert
import org.junit.Test

class QuickSortKtTest {

    @Test
    fun quickSort() {
        val array = arrayOf(1, 12, 5, 26, 7, 14, 3, 7, 2)
        quickSort(array)
        Assert.assertArrayEquals(
                arrayOf(1, 2, 3, 5, 7, 7, 12, 14, 26),
                array
        )
    }
}