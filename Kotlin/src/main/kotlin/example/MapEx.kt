package example

fun main() {

    val a = mutableMapOf("레드벨벳" to "음파",
        "트와이스" to "FANCY",
        "ITZY"  to "ICY")
    for (entry in a) {
        println("${entry.key} : ${entry.value}")
    }

    a.put("오마이걸", "번지")
    println(a)

    a.remove("ITZY")
    println(a)

    println(a["레드벨벳"])
}