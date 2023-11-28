package twoPointers

import kotlin.math.abs

fun main() {

    val array = arrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(largeArea(array.toIntArray()))
    println(largeAreaTwoPointers(array.toIntArray()))
}

fun largeAreaTwoPointers(heights: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = heights.lastIndex

    while (left < right) {
        val h = minOf(heights[left], heights[right])
        val w = right - left
        val area = h * w
        maxArea = maxOf(maxArea, area)

        if (heights[left] < heights[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}

fun largeArea(heights: IntArray): Int {
    var largestArea = 0

    for (i in heights.indices) {

        for (j in heights.indices) {
            if (i == j) continue
            val height = if (heights[i] > heights[j]) heights[j] else heights[i]
            val width = abs(i - j)
            val area = width * height
            if (area > largestArea)
                largestArea = area
        }
    }
    return largestArea
}
