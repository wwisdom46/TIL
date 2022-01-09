package ch4

open class RichButton : Clickable { // 열려있는 클래스. 다른 클래스가 이 클래스를 상속 가능
    fun disable() {} // final 함수로, 하위 클래스가 이 메소드를 오버라이드할 수 없다.
    open fun animate() {} // open된 함수로, 하위 클래스가 이 메소드를 오버라이드해도 된다.
    override fun click() {} // 이 함수는 (상위 클래스에서 선언된) open된 메소드를 오버라이드한다. 오버라이드한 메소드는 기본적으로 open되어 있다.
}