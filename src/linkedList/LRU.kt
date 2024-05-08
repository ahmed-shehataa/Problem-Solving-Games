package linkedList

data class MyNode(
    val key: Int,
    var value: Int,
    var prev: MyNode? = null,
    var next: MyNode? = null
)

class LRUCache(private val capacity: Int) {

    private val cache = HashMap<Int, MyNode>()
    private var head: MyNode? = null
    private var tail: MyNode? = null

    init {
        require(capacity > 0) { "Capacity must be greater than 0" }
    }
    fun get(key: Int): Int {
        val node = cache[key]
        node?.let { moveToHead(it) }
        return node?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            val existingNode = cache[key]!!
            existingNode.value = value
            moveToHead(existingNode)

        } else {
            val newNode = MyNode(key, value)
            cache[key] = newNode
            addToHead(newNode)

            if (cache.size > capacity) {
                cache.remove(tail!!.key)
                removeNode(tail!!)
            }
        }
    }

    private fun moveToHead(node: MyNode) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: MyNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev

        if (node == tail) {
            tail = node.prev
        }
    }

    private fun addToHead(node: MyNode) {
        node.next = head
        node.prev = null

        head?.prev = node
        head = node

        if (tail == null) {
            tail = node
        }
    }


}

fun main() {

    val lruCache = LRUCache(2)

    lruCache.put(1, 1)
    lruCache.put(2, 2)
    println(lruCache.get(1)) // Output: 1
    lruCache.put(3, 3) // evicts key 2
    println(lruCache.get(2)) // Output: -1 (not found)
    lruCache.put(4, 4) // evicts key 1
    println(lruCache.get(1)) // Output: -1 (not found)
    println(lruCache.get(3)) // Output: 3
    println(lruCache.get(4)) // Output: 4
}