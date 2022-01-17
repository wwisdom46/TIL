package ch5

fun main() {
    val naturalNumbers = generateSequence(0) { it + 1 } // 시퀀스 만드는 방법
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
    println(naturalNumbers)
}