package arrays

const val SEPARATOR = ":;"
fun main() {
    val array = arrayOf("Welcome", "to", "kotlin")

    val encodedString = encodeArray(array)
    println(encodedString)
    println(decodeString(encodedString).toList())
}

fun decodeString(encodedString: String): Array<String> {
    return encodedString.split(SEPARATOR).toTypedArray()
}

fun encodeArray(array: Array<String>): String {
    return array.joinToString(separator = SEPARATOR)
}
