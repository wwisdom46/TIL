package ch2

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0) ,
    YELLOW(255, 255, 0),
    GREEN(0, 255, 255),
    BLUE(0, 0, 255); // enum ㅋㅡㄹ래스 안에 메소드를 정의하는 경우 반드시 상수 목록과 메소드 사이에 세미콜론을 넣어야 함

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main() {
    println(Color.GREEN.rgb())
}