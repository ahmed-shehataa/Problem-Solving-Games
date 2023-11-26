package javaPs

class StringManipulation {


    companion object {
        @JvmStatic
        fun reverseSentence(str: String): String {
            return str.split(" ").asReversed().joinToString(separator = " ")
        }
    }


}

fun main(args: Array<String>) {
    println(StringManipulation.reverseSentence("asas"))
}