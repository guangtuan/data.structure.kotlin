package tech.igrant.dataStructure.sort

fun swap(input: Array<Int>, left: Int, right: Int) {
    val tmp = input[left]
    input[left] = input[right]
    input[right] = tmp
}

fun bubbleSort(input: Array<Int>) {
    for (i in 0 until input.size) {
        for (j in i until input.size) {
            if (input[i] < input[j]) {
                input[i] = input[j].also { input[j] = input[i] }
            }
        }
    }
}