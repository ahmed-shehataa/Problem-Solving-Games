package stack

fun main() {

    val position = arrayOf(10, 8, 0, 5, 3)
    val speed = arrayOf(2, 4, 1, 1, 3)
    val target = 12

    println(findFleets(target, speed, position))
}

fun findFleets(target: Int, speed: Array<Int>, position: Array<Int>): Int {
    val n = position.size
    val cars = Array(n) { Pair(position[it], speed[it]) }
    cars.sortByDescending { it.first }

    println(cars.toList())

    var fleets = 0
    var timeToReachTarget = DoubleArray(n)

    for (i in 0 until n) {
        timeToReachTarget[i] = (target - cars[i].first).toDouble() / cars[i].second
    }

    for (i in 0 until n - 1) {
        if (timeToReachTarget[i] < timeToReachTarget[i + 1]) {
            fleets++
        } else {
            timeToReachTarget[i + 1] = timeToReachTarget[i]
        }
    }

    return fleets + if (n > 0) 1 else 0
}
