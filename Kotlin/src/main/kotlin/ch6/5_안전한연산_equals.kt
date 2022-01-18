package ch6

class Person2(val firstName: String, val lastName: String) {
    override fun equals(o: Any?) : Boolean {
        val otherPerson = o as? Person2 ?: return false // o 가 Person2와 타입이 일치하지 않으면 false 리턴
        return otherPerson.firstName == firstName && // 안전한 캐스트를 하고나면 otherPerson이 Person 타입으로 스마트 캐스트된다.
                otherPerson.lastName == lastName
    }
    override fun hashCode() : Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun main() {
    val p1 = Person2("Dmitry", "Jemerov")
    val p2 = Person2("Dmitry", "Jemerov")
    println(p1 == p2) // == 연산자는 equals 메소드를 호출
    println(p1.equals(42))
}