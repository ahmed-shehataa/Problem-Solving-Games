package stack

import java.util.*


fun main() {

    val temps = arrayOf(73, 74, 75, 71, 69, 72, 76, 73)

    findDays(temps)
}

fun findDays(temps: Array<Int>) {
    val stack = Stack<Int>()
    val result = IntArray(temps.size)

    for (i in temps.indices) {
        while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
            val stackTempIndex = stack.pop()
            result[stackTempIndex] = i - stackTempIndex
        }
        stack.add(i)
    }
    println(result.toList())
}