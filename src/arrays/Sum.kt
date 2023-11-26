package arrays

fun main() {

    val array = arrayOf(1, 2, 3, 4, 5)
    val target = 6
    sum(array, target)

}

fun sum(array: Array<Int>, target: Int) {

    outer@ for (i in array.indices) {
        inner@ for (j in i +1 until array.size) {
            if (array[i] + array[j] == target) {
                println("indexes: $i and $j")
            }

        }
    }

}
