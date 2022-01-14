package ch5

fun main() {
    // filter 함수는 컬렉션에서 원치않는 원소를 제거하지만 원소를 변환할 수는 없다.
    // 원소를 변환하기 위해선 map 함수를 사용해야 한다.
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0})

    val people = listOf(Person("Alice", 29), Person("Hey", 45), Person("Bob", 31))
    println(people.filter { it.age > 30})

    // map 함수는 주어진 람다를 컬렉션의 각 원소에 적용한 결과를 모아서 새 컬렉션을 만든다.
    println(list.map {it * it})
    println(list.map {it % 2 == 0})

    println(people.filter{it.age > 30}.map(Person::name))
    println(people.filter{it.age == people.maxByOrNull(Person::name)!!.age})
}
