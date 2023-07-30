//별출력 6가지 방법(feat.강사님)
//0
fun printStars(n: Int) {
    for (i in 1..n) {
        if (i % 2 == 1) {
            for (j in 1..i) {
                print("*")
            }
            println()
        }
    }
}
//1
fun printStars1(n: Int) {
    for (i in 1..n) {
        if (i % 2 == 1) {
            printStarLine1(i)
        }
    }
}
fun printStarLine1(n: Int) {
    for (i in 1..n) {
        print("*")
    }
    println()
}
//2
fun printStars2(n: Int) {
    for (i in 1..n step 2) {
        println(getStarLine2(i))
    }
}
fun getStarLine2(n: Int) = "*".repeat(n)
//3
fun printStars3(n: Int) {
    (1..n step 2).forEach { println("*".repeat(it)) }
}
//4
fun printStars4(n: Int) {
    (1..n step 2).forEach(::printStarLine4)
}
fun printStarLine4(n: Int) = println("*".repeat(n))
//5
fun printStars5(n: Int) {
    repeat(n) { if (it % 2 == 1) println("*".repeat(it)) }
}
println("printStars")
printStars(10)
println("printStars1")
printStars1(10)
println("printStars2")
printStars2(10)
println("printStars3")
printStars3(10)
println("printStars4")
printStars4(10)
println("printStars5")
printStars5(10
