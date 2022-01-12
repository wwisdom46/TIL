package ch5

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach{ // 각 원소에 대해 수행할 작업을 람다로 받는다
        (println("$prefix $it")) // 람다 안에서 함수의 "prefix" 파라미터 사용
    }
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
}
