fun main() {
    val number: Int by lazy {
        println("초기화")
        7
    }
    println("코드 시작")
    println(number)
    println(number)

    // 출력결과
    // 코드시작
    // 초기화
    // 7
    // 7 <------ 이미 초기화 되었기 때문에 다시 초기화 구문 실행하지 않고 바로 7 출력

}