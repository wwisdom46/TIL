package ch5

// buildString : StringBuilder를 활용해 String을 만드는 경우 사용
fun alphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")

}

fun main() {
    println(alphabet())
}