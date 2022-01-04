package ch3

// 확장 프로퍼티는 일반 프로퍼티와 같지만 단지 수신 객체 클래스가 추가됨
// 뒷받침하는 필드가 없어서 기본 게터 구현을 제공할 수 없으므로 최소한 게터는 꼭 정의를 해야 함.
// 마찬가지로 초기화 코드에서 계산한 값을 담을 장소가 없으므로 초기화 코드도 쓸 수 없음
var StringBuilder.lastChar: Char
    get() = get(length - 1) // 프로퍼티 게터
    set (value: Char) {
        this.setCharAt(length -1, value) // 프로퍼티 세터
    }

fun main() {
    println("Kotlin".lastChar())
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}