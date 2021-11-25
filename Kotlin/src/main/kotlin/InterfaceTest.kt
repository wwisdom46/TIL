fun main() {
    var d = Dog()
    d.run()
    d.eat()
}

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println ("음식을 먹습니다")
    }
}

class Dog : Runner, Eater { // 두 인터페이스 상속
    override fun run() {
        println ("뜁니다")
    }
}