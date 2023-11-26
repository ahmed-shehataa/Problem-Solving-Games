package arrays


fun main() {

    val array = arrayOf(1, 2, 3, 4)
    val array2 = arrayOf(-1, 1, 0, -3, 3)

    getProductOf(array)
    getProductOf(array2)
}

fun getProductOf(array: Array<Int>) {
    val result = IntArray(array.size)

    outer@ for (i in array.indices) {
        var resSum = 1

        inner@ for (j in array.indices) {
            if (i == j) continue@inner
            resSum *= array[j]
        }
        // set the resSum
        result[i] = resSum
    }

    println("Input: " + array.toList().toString())
    println("Output: " + result.toList().toString())

}
