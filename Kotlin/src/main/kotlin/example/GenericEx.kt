package example//fun main() {
//    UsingGeneric(A()).doShouting()
//    UsingGeneric(B()).doShouting()
//    UsingGeneric(C()).doShouting()
//
//    doShouting(B()) // 캐스팅 없이 B의 객체 그대로 함수에서 사
//}
//
//fun <T: A> doShouting(t: T) {
//     t.shout()
//}
//
//open class A {
//    open fun shout() {
//        println("A shout")
//    }
//}
//
//class B : A() {
//    open fun shout() {
//        println("B shout")
//    }
//}
//
// class C : A() {
//    open fun shout() {
//        println("A shout")
//    }
//}
//
//class UsingGeneric<T: A> (val t: T){
//    fun doShouting() {
//        t.shout()
//    }
//}