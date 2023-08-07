fun main() {
    val americano1 = Americano("아메리카노",2500, "원두")
    americano1.printInfo()
}

open class Coffee(val name: String, val price: Int, val ingredient: String) {
    open fun printInfo() {
        println("name : $name, price : $price, ingredient : $ingredient")
    }
}

class Americano(name: String, price: Int, ingredient: String): Coffee(name, price, ingredient) {
    override fun printInfo() {
        super.printInfo()
        println("뜨거우니 조심하세요")
    }
}
