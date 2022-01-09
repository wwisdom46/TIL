package ch4

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr) : Int =
    when (e) { // when 식에서 sealed 클래스의 모든 하위 클래스를 처리하기 때문에 별도의 else 분기가 없어도 됨
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }