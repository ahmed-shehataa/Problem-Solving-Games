package arrays


fun main() {

    val str = "anagram"
    val str1 = "nagaram"

    val cat  = "cat"
    val rat = "rat"

    checkAnagram(str, str1)
    checkAnagram(cat, rat)

}

fun checkAnagram(str: String, str1: String) {
    if (str.length != str1.length) {
        println("False")
        return
    }

    val first: CharArray = str.toCharArray().apply {
        sort()
    }
    val second: CharArray = str1.toCharArray().apply {
        sort()
    }

    var isValid = true
    for (i in first.indices) {
        if (first.get(i) != second.get(i)) {
            isValid = false
            break
        }
    }

    println(isValid)

}
