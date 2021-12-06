fun main() {
    sum(1, 2, 3, 4)
}

fun sum(vararg numbers: Int) {
    var sum = 0

    for (n in numbers) {
        sum += n
    }
    print(sum)
}