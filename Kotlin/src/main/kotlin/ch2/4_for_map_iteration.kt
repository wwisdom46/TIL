package ch2

import java.util.*

fun main() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary // c를 키로 c의 2진 표현을 맵에 넣는다
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}