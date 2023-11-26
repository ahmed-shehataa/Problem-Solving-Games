package arrays


fun main() {

    val array = arrayOf(1, 2, 3, 4, 5)
    val array1 = arrayOf(1, 2, 6, 4, 6)

    hasDupInt(array)
    hasDupInt(array1)
}

private fun hasDupInt(array: Array<Int>) {
    var hasDup = false

    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] == array[j])
                hasDup = true
        }
    }

    println(array.toList().toString() + " hasDup: " + hasDup)
}
