package example

fun main () {
    data class Person(val name: String, val birthYear: Int)

    val personList = listOf(Person("유나", 1992),
        Person("조이", 1996),
        Person("츄", 1999),
        Person("루루", 2003))

    println(personList.associateBy { it.birthYear })
    println(personList.groupBy { it.name })

    val (over98, under98) = personList.partition { it.birthYear > 1998 }
    println(over98)
    println(under98)

    val numbers = listOf(-3, 7, 2, -10, 1)

    println(numbers.flatMap { listOf(it * 10, it + 10) }) // [-30, 7, 70, 17, 20, 12, -100, 0, 10, 11]

    println(numbers.getOrElse(1) { 50 }) // 7
    println(numbers.getOrElse(10) { 50 }) // 50

    val names = listOf("A", "B", "C", "D")

    println(names zip numbers) // [(A, -3), (B, 7), (C, 2), (D, -10)]
}