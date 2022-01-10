package ch2

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z' -> "It's a letter"
    else -> "I don't know..."
}

fun main() {
    println(recognize('흰'))
    println(recognize('ㅋ'))
    println(recognize('b'))
}
