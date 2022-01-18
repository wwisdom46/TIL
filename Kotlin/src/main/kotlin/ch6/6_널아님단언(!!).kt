package ch6

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!! // 널 아님 단언
    println(sNotNull.length)
}

fun main() {
    ignoreNulls(null)
}