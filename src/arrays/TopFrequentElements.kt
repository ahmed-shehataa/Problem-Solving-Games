package arrays

fun main() {

    val array = arrayOf(1, 1, 1, 1, 2, 3, 3, 3, 4, 5)
    val k = 2
    topItems(array, k)

}

fun topItems(array: Array<Int>, k: Int) {
    val map = mutableMapOf<Int, Int>()

    for (item in array) {
        map[item] = map.getOrDefault(item, 0) + 1
    }


    println(map.toSortedMap().toList().toString())
}
