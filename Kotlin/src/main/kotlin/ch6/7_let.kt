package ch6

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun main() {
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) } // null이 아닐 때에만 수행
    email = null
    email?.let { sendEmailTo(it) }
    
    
    //val person: Person? = getTheBestPersonInTheWorld()
    //if (person != null) sendEmailTo(person.email)
    
    // 위 두 줄을 아래 한 줄로 변경 가능
    // getTheBestPersonInTheWorld()?.let { sendEmailTo(it.email) }
    
}
