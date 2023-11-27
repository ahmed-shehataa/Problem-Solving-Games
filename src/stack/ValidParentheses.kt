package stack

import java.util.Stack

fun main() {
    val one = "()"
    val two = "{}[]()"
    val three = "{][]()"

    println(isValidParentheses(one))
    println(isValidParentheses(two))
    println(isValidParentheses(three))
}

fun isValidParentheses(str: String): Boolean {
    if (str.length % 2 != 0) return false

    val stack = Stack<Char>()

    for (char in str) {
        when(char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> {
                if (stack.pop() != '(') return false
            }
            '}' -> {
                if (stack.pop() != '{') return false
            }
            ']' -> {
                if (stack.pop() != '[') return false
            }
        }
    }

    return true

}
