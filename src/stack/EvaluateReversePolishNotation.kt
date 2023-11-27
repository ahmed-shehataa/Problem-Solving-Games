package stack

import java.util.Stack

fun main() {
    val str = arrayOf("2", "1", "+", "3", "*")
    val str1 = arrayOf("4", "13", "5", "/", "+")
    val str2 = arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")

    solveOperation(str)
    solveOperation(str1)
    solveOperation(str2)
}

fun solveOperation(str: Array<String>) {
    val stack = Stack<Int>()

    for (char in str) {
        when(char) {
            "+" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op1 + op2)
            }

            "-" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op1 - op2)
            }

            "*" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op1 * op2)
            }

            "/" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 / op1)
            }

            else -> {
                // num
                stack.add(char.toInt())
            }
        }
    }

    println(stack.pop())
}
