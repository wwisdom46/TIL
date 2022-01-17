package ch6

fun strLenSafe2(s: String?) : Int = s?.length ?: 0 // null 이면 우측 값 0 리턴

fun printShippingLabel(person: Person) {
    val address = person.company?.address?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main() {
    println(strLenSafe2("abc"))
    println(strLenSafe2(null))
    println(strLenSafe2(""))

    val address = Address("Elsestr. 47", 80867, "Munich", "Germany")
    val jetbrains = Company("Jetbrains", address)
    val person = Person("Dmitry", jetbrains)

    printShippingLabel(person)
    printShippingLabel(Person("Alexy", null))
}