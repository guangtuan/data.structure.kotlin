package tech.igrant.dataStructure.sort

fun sort(array: Array<Int>, left: Int, right: Int) {
    var i = left
    var j = right
    val pivot = array[(left + right) / 2]

    while(i <= j) {
        while (array[i] < pivot) {
            i++
        }
        while (array[j] > pivot) {
            j--
        }
        if (i <= j) {
            array[i] = array[j].also { array[j] = array[i] }
            i++
            j--
        }

        if (left < j) {
            sort(array, left, j)
        }
        if (i < right) {
            sort(array, i, right)
        }
    }
}

fun quickSort(input: Array<Int>) {
    sort(input, 0, input.size - 1)
}