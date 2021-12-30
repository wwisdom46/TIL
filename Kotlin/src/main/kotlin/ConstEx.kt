fun main() {
    var foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PAST)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
}

class FoodCourt {
    fun searchPrice(foodName: String) {
        val price = when(foodName) {
            FOOD_CREAM_PAST -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }
        println("${foodName}의 가격은 ${price}원 입니다")
    }

    companion object {
        const val FOOD_CREAM_PAST = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}