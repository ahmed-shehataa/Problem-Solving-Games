package slidingWindow

fun main() {

    val prices = arrayOf(7, 1, 5, 3, 6, 4, 15)

    println(find(prices.toIntArray()))
}

fun find(prices: IntArray): Int {
    var left = 0
    var right = 1
    var maxProfit = 0

    while (right < prices.size) {
        val profit = prices[right] - prices[left]
        if (profit < 0) {
            // you are losing so
            left = right
            right++
        } else {
            // you are making a profit
            maxProfit = maxOf(maxProfit, profit)
            right++
        }
    }

    return maxProfit
}
