package ch3

import ch3.lastChar
import ch3.lastChar as last

fun main() {
    println("Kotlin".lastChar())
    println("Kotlin".last()) // as 를 사용하여 임포트 할 함수명 수정가능. 이를 통해 동일함수 이름 충돌 방지 가능
}