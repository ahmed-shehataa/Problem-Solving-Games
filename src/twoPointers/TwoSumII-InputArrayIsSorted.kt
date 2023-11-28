package twoPointers

fun main() {
    val array = arrayOf(2, 7, 11, 15)
    val target = 9

    println(findTargetIndex(array, target).toList())
}

fun findTargetIndex(numbers: Array<Int>, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex

    while (left < right) {
        val sum = numbers[left] + numbers[right]
        if (sum < target) left++
        else if (sum > target) right--
        else {
            return arrayOf(left + 1, right + 1).toIntArray()
        }
    }

    return IntArray(2)
}
