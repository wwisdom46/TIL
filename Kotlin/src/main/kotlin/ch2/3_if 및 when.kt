package ch2

fun evalIf(e: Expr) : Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalIf(e.right) + evalIf(e.left)
    } else {
        throw IllegalArgumentException("Unknow expression")
    }

// 위 if를 when으로 리팩토링
fun evalWhen(e: Expr) : Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            evalWhen(e.right) + evalWhen(e.left)
        else ->
            throw IllegalArgumentException("Unknow expression")
    }

fun main() {

    println(evalIf(Num(1)))
    println(evalWhen(Num(1)))

    println(evalIf(Sum(Num(1), Num(2))))
    println(evalWhen(Sum(Num(1), Num(2))))
}