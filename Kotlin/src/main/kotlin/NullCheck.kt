fun main() {

    var a: String? = null

    println(a?.toUpperCase())
    println(a?:"default".toUpperCase())
    println(a!!.toUpperCase()) // NPE 발

    a?.run { // null 일 땐 실행이 되지 않음
        println(toUpperCase())
        println(toLowerCase())
    }

}