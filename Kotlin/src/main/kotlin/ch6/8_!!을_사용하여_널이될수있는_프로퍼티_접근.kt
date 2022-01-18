package ch6

class MyService {
    fun performAcction() : String = "foo"
}

class MyTest {
    private var myService: MyService?= null // null로 초기화하기 위해 널이 될 수 있는 타입인 프로퍼티 선언
    
    fun setUp() {
        myService = MyService() // setUp 메소드 안에서 진짜 초기값 지정
    }

    fun testAction() {
        myService?.performAcction() ?: "null" // 반드시 널 가능성에 신경을 써야 한다. -> ? 사용
        myService!!.performAcction() // 반드시 널 가능성에 신경을 써야 한다. -> !! 사용
    }
}