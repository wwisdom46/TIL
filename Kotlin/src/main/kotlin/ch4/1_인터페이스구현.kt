package ch4

class Button : Clickable, Focusable { // 코틀린에서는 클래스 이름 뒤에 콜론을 붙이고 인터페이스와 클래스 이름을 적는것으로 클래스의 확장과 인터페이스 구현을 모두 처리
    override fun click() = println("I was clicked") // 여기서 override는 상위 클래스나 인터페이스에 있는 프로퍼티나 메소드를 오버라이드 한다는 표시
    //override fun showOff() // 컴파일 오류 발생
    override fun showOff() {
        super<Clickable>.showOff() // 상위 타입의 이름을 꺾쇠 괄호(<>) 사이에 넣어서 "super"를 지정하면 어떤 상위 타입의 멤버 메소드를 호출할지 지정할 수 있음
        super<Focusable>.showOff()
        // 자바였다면? Clickable.super.showOff()
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}