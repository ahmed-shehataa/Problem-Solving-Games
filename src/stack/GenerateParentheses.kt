package stack

import java.util.*

/**
 * NOT SOLVED
 */
fun main() {
    val n = 3
    generate(n)
}

fun generate(n: Int) {
    val stack = Stack<Char>().apply {
       // push('(')
    }
    backTrack(0, 0, n, stack)
}

fun backTrack(opened: Int, closed: Int, size: Int, stack: Stack<Char>) {
    if (opened == size && closed == size) {
        // done
        val reversedList = mutableListOf<Char>()
        while (!stack.isEmpty()) {
            val item = stack.pop()
            reversedList.add(item)
        }

        val finialResult = reversedList.reversed().joinToString(separator = "")
        println(finialResult)
        return
    }

    if (opened == 0) {
        // init stack
        stack.add('(')
        backTrack(opened = 1, closed = closed, size, stack)
    }

    if (opened < size) {
        // add ( to stack
        stack.add('(')
        backTrack(opened = opened + 1, closed = closed, size, stack)
    }

    if (closed < opened && closed <= size) {
        // add ) to stack
        stack.add(')')
        backTrack(opened = opened, closed = closed + 1, size, stack)
    }

}
