package ch4

// internal : 같은 모듈 안에서만 볼 수 있다.
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech() { public 멤버가 자신의 internal 수신타입인 TalkativeButton을 노출해서 오류
//    yell() // TalkativeButton의 private 멤버이기 때문에 접근 불가
//    whisper() // TalkativeButton의 protected 멤버이기 때문에 접근 불가
//}