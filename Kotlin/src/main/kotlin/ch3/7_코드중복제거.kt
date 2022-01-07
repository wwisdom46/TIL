package ch3

class User(val id: Int, val name: String, val address: String)

// 코드 중복 케이스
/*fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }
}*/

// 위 코드를 로컬함수를 사용하여 코드 중복을 줄임
/*fun saveUser(user: User) {

    fun validate(user: User,
                 value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name") // 로컬 함수를 호출헤서 각 필드를 검증
    validate(user, user.address, "Address")
}*/

// 위 코드에서 불필요한 User 파라미터를 없애기
fun saveUser(user:User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " + // 바깥 함수의 파라미터에 직접 접근 가능
                        "empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun main() {
    saveUser(User(1, "", ""))
}
