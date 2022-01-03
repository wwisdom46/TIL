package example

fun main() {
    val a = LateInitSample()

    println(a.getLateInitText())
    a.text = "새로 할당한 값"
    println(a.getLateInitText())
}

class LateInitSample {
    lateinit var text: String

    fun getLateInitText(): String {
        if (::text.isInitialized) {
            return text;
        } else {
            return "기본값"
        }
    }
}