package ch2

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) : Int? { // throws 절이 코드에 없는게 코틀린 특징
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

// try를 식으로 사용
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    val reader2 = BufferedReader(StringReader("2"))
    println(readNumber(reader))
    readNumber2(reader2)
}