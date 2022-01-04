package ch3

fun <T> Collection<T>.joinToString (
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) { // this 는 수신객체. 여기서는 T타입의 원소로 이루어진 컬렉션
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf(1, 2, 3)
    println(list.joinToString(";", "(", ")"))
}