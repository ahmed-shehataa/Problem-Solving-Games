package arrays

fun main() {

    val array = arrayOf(1, 2, 3, 4, 5)
    val target = 6
    sum(array, target)
}

fun sum(nums: Array<Int>, target: Int): IntArray {

    outer@ for (i in nums.indices) {
        inner@ for (j in i +1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return arrayOf(i, j).toIntArray()
            }
        }
    }
    return arrayOf(0,0).toIntArray()

}
