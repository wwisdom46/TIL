package ch4

open class RichButton2 : Clickable {
    final override fun click() {} // 하위 클래스에서 오버라이드하지 못하게 final 명시
}