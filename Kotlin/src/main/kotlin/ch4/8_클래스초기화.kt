package ch4

class User constructor(_nickname: String) { // 파라미터가 하나만 있는 주 생성자. constructor 키워드는 주생성자나 부생성자 정의를 시작할 때 사용
    val nickname: String
    init { // 초기화 블록. 초기화 블록은 주생성자와 함께 사용
        nickname = _nickname
    }
}

class User2(_nickname: String) {
    val nickname = _nickname
}

class User3(val nickname: String)

class User4(val nickname: String, val isSubscribed: Boolean = true ) // 생성자 파라미터에 대한 디폴트 값 제공




fun main() {
    val hyun = User4("홍길동")
    println(hyun.isSubscribed)
}