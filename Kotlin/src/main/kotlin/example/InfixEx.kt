package example

fun main() {
    println(6 multiply 4) // 좌측 6이 infix 함수가 적용되는 객체 자. 즉 this 해당. 4는 파라미터
    println(6.multiply(4)) // 일반적인 클래스의 함수를 사용하는 것 처럼 사용한 예시
}

infix fun Int.multiply(x: Int): Int = this * x