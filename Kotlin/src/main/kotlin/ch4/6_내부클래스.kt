package ch4

import java.io.Serializable

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button2() : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State {} // 코틀린 중첩 클래스에 아무런 변경자가 붙지않으면 자바 static 중첩 클래스와 같다.
}

