fun main() {
    val car1 = Car("KIA", Color.BLUE, 3, 3)
    car1.printCarInfo()
    car1.getSpeeds()
    car1.increaseSpeed()
	    car1.addGas(3)

}

enum class Color(R: Int, G: Int, B: Int) {
    BLACK(0, 0, 0),
    WHITE(255, 255, 255),
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255)
}

class Car(var model: String, var color: Color, var speed: Int, var gas: Int) {

    fun printCarInfo() {
        println("model : $model")
        println("color : $color")
        println("speed : $speed")
        println("gas : $gas")
    }

    fun getSpeeds(): Int {
        return speed
    }

    fun increaseSpeed(): Unit {
        speed++
        println("speed up! Current speed is $speed")
    }

    fun addGas(newGas: Int): Unit {
        gas += newGas
        println("gas up! Current gas quantity is $gas")
    }
}
