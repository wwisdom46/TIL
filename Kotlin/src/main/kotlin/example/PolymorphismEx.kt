package example

fun main() {
    var a = Drink()
    a.drink()

    var b: Drink = Cola()
    b.drink()

    // b.washDishes() // 참조 불가 에러 발생.

    if(b is Cola) // is 는 조건문 안에서만 다운캐스팅
    {
        b.washDishes()
    }
    var c = b as Cola
    c.washDishes()
    b.washDishes() // 아까와 달리 참조 가능. as 사용 시 변수 자체도 다운캐스팅이 되기 때문!
}

open class Drink {
    var name = "음료"

    open fun drink() {
        println("${name}를 마십니다")
    }
}

class Cola: Drink() {
    var type = "콜라"

    override fun drink() {
        println("${name}중에 ${type}를 마십니다")
    }

    fun washDishes() {
        println("${type}로 설거지를 합니다")
    }
}