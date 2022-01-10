package ch2

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard" // 만약 Color 를 import 해서 사용한다면 굳이 앞에 Color 안 붙여도 됨
        Color.YELLOW -> "Of"
        Color.BLUE -> "York"
        Color.GREEN -> "Gave"
    }


fun main() {
    println(getMnemonic(Color.GREEN))
}