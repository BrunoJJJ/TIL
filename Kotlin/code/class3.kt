class MyCafe(val name: String, val adress: String, val rentFee: Int, val menu: String) {
    fun printInfo() {
        println("name : $name, adress : $adress, rent fee : $rentFee, menu : $menu")
    }
}

open class Coffee(val name: String, val price: Int, val ingredient: String) {
    var shot = 0
    var water = 0
    var shotPrice = 500
    var waterPrice = 100

    open fun printInfo() {
        println("name : $name, price : $price, ingredient : $ingredient")
    }
    open fun addSomething(input: String, times: Int = 1) {
        for (i in 1..times) {
            if (input == "shot") {
                shot++
            } else if (input == "water") {
                water++
            } else {
                "${input}은 추가할 수 없습니다."
            }
        }
        println("plus $input $times")
    }
    open fun calcPrice(): Int {
        return price + shot*shotPrice + water*waterPrice
    }
}

class HotAmericano(name: String = "Americano", price: Int, ingredient: String): Coffee(name, price, ingredient) {
    override fun printInfo() {
        super.printInfo()
        println("뜨거우니 조심하세요.")
    }
}

class IceAmericano(name: String = "americano", price: Int, ingredient: String): Coffee(name, price, ingredient) {
    var ice = 0
    var icePrice = 200

    override fun addSomething(input: String, times: Int) {
        super.addSomething(input, times)
        if (input == "ice") {ice++}
        else {"${input}은 추가할 수 없습니다."}
    }

    override fun calcPrice(): Int {
        return super.calcPrice() + ice*icePrice
    }
}

fun main() {
    val hotAmericano1 = HotAmericano(price = 3000, ingredient = "아라비카")
    val iceAmericano1 = IceAmericano("americano", 3000, "로부스타")

    hotAmericano1.printInfo()
    hotAmericano1.addSomething("shot", 3)
    println(hotAmericano1.calcPrice())

    iceAmericano1.printInfo()
    iceAmericano1.addSomething("shot", 2)
    iceAmericano1.addSomething("ice", 2)
    println(iceAmericano1.calcPrice())
}

// cf. 접근제한자, overload + object() 등 써보기
