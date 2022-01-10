package ch3

// 코틀린은 정규식을 사용하지 않고도 문자열을 쉽게 파싱할 수 있다.
fun parePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun main() {
    parePath("/Users/yole/kotlin-book/chapter.adoc")
}