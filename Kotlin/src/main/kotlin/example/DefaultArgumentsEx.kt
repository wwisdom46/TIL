package example

fun main() {

    deliveryItem("책")
    deliveryItem("커피", 3)
    deliveryItem("맥북", 30, "회사")

    deliveryItem("선물", destination = "카페")

}

fun deliveryItem(name: String, count: Int = 1, destination: String = "집") {
    println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
}