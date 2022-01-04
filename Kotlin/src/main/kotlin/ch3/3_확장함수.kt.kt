package ch3

// 아래 함수는 확장함수로, 확장함수란 어떤 클래스의 멤버 메소드인 것처럼 호출할 수 있지만 그 클래스의 밖에 선언된 함수
// String이 수신 객체 타입
fun String.lastChar() : Char = this.get(this.length - 1)

// "Kotlin"이 수신 객체
fun main() {
    println("Kotlin".lastChar())
}