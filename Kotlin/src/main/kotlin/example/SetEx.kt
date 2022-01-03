package example

fun main() {

    val a = mutableSetOf("귤", "바나나", "키위")

    for (item in a) {
        println("${item}")
    }

    a.add("자몽")
    println(a)

    a.remove("바나나")
    println(a)

}