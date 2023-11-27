package arrays


fun main() {

    val str = arrayOf("cat", "tea", "eat", "art", "rat", "music")

    checkAnagramGroup(str)

}

fun checkAnagramGroup(strs: Array<String>): List<MutableList<String>> {

    val groupMap = mutableMapOf<String, MutableList<String>>()

    for (word in strs) {
        val keyOfWord = String(word.toCharArray().sortedArray())

        val getPreviousList = groupMap.getOrDefault(keyOfWord, mutableListOf()).apply {
            add(word)
        }
        groupMap[keyOfWord] = getPreviousList

    }

    println(groupMap.values.toList().toString())
    return groupMap.values.toList()
}
