package ch5

fun main () {
    // 1. 이름 붙인 인자를 사용해 람다 넘기기
    val people = listOf(Person("이몽룡", 29), Person("성춘향", 31))
    val names = people.joinToString(separator = " ",
                                    transform = {p: Person -> p.name})
    // 2. 람다를 괄호 밖에 전달하기
    people.joinToString(" ") { p: Person -> p.name }
}