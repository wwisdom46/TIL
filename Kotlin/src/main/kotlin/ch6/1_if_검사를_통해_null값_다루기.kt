package ch6

fun strLenSafe(s:String?): Int = if (s != null) s.length else 0
// fun strLenSafe2(s:String?): Int = s.length // null 검사 추가해야만 컴파일이 된다.

fun main() {
    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe(""))
    println(strLenSafe(null))
    println(strLenSafe("abc"))

}