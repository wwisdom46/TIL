package ch3

fun paresePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // 1. 정규식을 만들고
    val matchResult = regex.matchEntire(path) // 2. 그 정규식을 인자로 받은 path에 매치
    if (matchResult != null) { // 3. 매치에 성공하면(null이 아니면 성공)
        val (directory, filename, extension) = matchResult.destructured // 4. destructured 프로퍼티(그룹별로 분해한 매치 결과)를 각 변수에 대입
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun main() {
    paresePath("/Users/yole/kotlin-book/chapter.adoc")
}