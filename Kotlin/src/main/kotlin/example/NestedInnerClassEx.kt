package example

fun main () {
    Outer.Nested().introduce() // Nested Class

    val outer = Outer()
    val inner = outer.Inner()

    inner.introduceInner() // Inner Class
    inner.introduceOuter() // Outer Class

    outer.text = "Changed Outer Class"
    inner.introduceOuter() // Changed Outer Class

}
class Outer {
    var text = "Outer Class"
    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }
    
    inner class Inner {
        var text = "Inner Class"

        fun introduceInner() {
            println(text)
        }
        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}