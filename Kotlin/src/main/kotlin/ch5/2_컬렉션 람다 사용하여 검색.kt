package ch5

fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.maxByOrNull {it.age})
    println(people.maxByOrNull({ p: Person -> p.age }))
    println(people.maxByOrNull() { p: Person -> p.age })
    println(people.maxByOrNull { p: Person -> p.age })
    println(people.maxByOrNull { p -> p.age }) // 람다 파라미터 타입 제거
    println(people.maxByOrNull { it.age }) // 디폴트 파라미터 이름 it 사용
}