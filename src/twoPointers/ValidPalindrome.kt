package twoPointers

import java.lang.StringBuilder

fun main() {

    val string = "A man, a plan, a canal: Panama"
    val string2 = "race a car"

    println(isValid(string))
    println(isValid(string2))

}

private fun isValid(s: String) : Boolean{
    val builder = StringBuilder()

    for (char in s) {
        if (char.isLetterOrDigit())
            builder.append(char.toLowerCase())
    }

    var left = 0
    var right = builder.lastIndex

    println( builder.length)
    while (left < right) {
        println("$left : :$right")
        if (builder[left] != builder[right])
            return false
        left ++
        right --
    }
    return true
}
