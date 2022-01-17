package ch6

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName() : String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"

    //return company?.address?.country ?: "Unknown"턴 // 엘비스 연산자를 사용하여 위 두 줄을 한 줄로 표현 가능
}

fun main() {
    val person = Person("Dmitry", null)
    println(person.countryName())
}