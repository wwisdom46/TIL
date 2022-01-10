package ch3

fun main() {
    val set = hashSetOf(1, 7, 53)
    println(set.size)
    println(set.javaClass) // javaClass는 자바 getClass()에 해당하는 코틀린 코드

    val list = arrayListOf(1, 7, 53)
    println(list.javaClass)

    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")
    println(strings.javaClass)
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.javaClass)

}