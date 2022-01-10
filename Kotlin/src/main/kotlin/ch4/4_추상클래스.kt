package ch4

// 추상 클래스에는 구현이 없는 추상 멤버가 있기 때문에 하위 클래스에서 그 추상 멤버를 오버라이드해야만 하는게 보토ㅓㅇ이다.
// 추상 멤버는 항상 열려있다.
// 따라서 추상 멤버 앞에 open 변경자를 명시할 필요가 없다.
abstract class Animated { // 추상클래스로 이 클래스으 ㅣ인스턴스를 만들 수 없다
    abstract fun animate() // 추상 함수로 하위 클래스에서 반드시 오버라이드 해야 함
    open fun stopAnimating() { // 추상 클래스에 속했더라도 비추상 함수는 기본적으로 final이지만 open으로 오버라이드 허용 가능

    }
    fun animateTwice() {

    }
}