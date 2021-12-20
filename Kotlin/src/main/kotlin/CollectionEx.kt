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
}