package linkedList

import java.util.*


class ListNode(val value: Int) {
    var next: ListNode? = null
}

fun main() {

    val node5 = ListNode(1)

    val node4 = ListNode(2).apply {
        next = node5
    }

    val node3 = ListNode(3).apply {
        next = node4
    }
    val node2 = ListNode(4).apply {
        next = node3
    }
    val node1 = ListNode(5).apply {
        next = node2
    }

    println(reverseList(node5)?.value)
    println(reverseListStack(node1)?.value.toString())

}

fun reverseListStack(node: ListNode): ListNode? {
    val stack = Stack<ListNode>()
    var currentNode: ListNode? = node
    while (currentNode != null) {
        stack.push(node)
        currentNode = currentNode.next
    }

    while (stack.isNotEmpty()) {
        stack
    }
    return null
}

fun reverseList(head: ListNode): ListNode? {
    var prev: ListNode? = null
    var current: ListNode? = head

    while (current != null) {
        val nextTemp = current.next
        current.next = prev
        prev = current
        current = nextTemp
    }

    return prev
}
