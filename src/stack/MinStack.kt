package stack

fun main() {

    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3

    minStack.pop()
    println(minStack.top()) // return 0

    println(minStack.getMin())// return -2

}

class MinStack {

    private val array = IntArray(100)
    private var topIndex = -1
    private var minValue: Int? = null

    fun push(num: Int) {
        topIndex++
        if (topIndex == array.size) throw ArrayStoreException("Array limited 100 items only")

        array[topIndex] = num
        placeSmallNumber(num)
    }

    private fun placeSmallNumber(num: Int) {
        if (minValue == null) {
            minValue = num
        } else {
            if (minValue!! > num)
                minValue = num
        }
    }

    fun pop() {
        array[topIndex] = 0
        topIndex--
    }

    fun top(): Int {
        return array[topIndex]
    }

    fun getMin(): Int? {
        return minValue
    }
}