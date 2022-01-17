package ch6

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee) : String? = employee.manager?.name // ?. null이면 null출력

fun main() {
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))
}