// pseudo code
// start
// 소인수 분해할 자연수 n 선언
// 소인수 분해를 위한 소수 primeFactor 값 2 선언
// 소인수 분해 값을 저장할 list<Int> 선언
// 자연수 n이 1이 될때까지 반복
// 만약 자연수가 소수로 나누어진다면, list에 소수를 추가하고 소수로 나누어진 자연수 값은 다시 n에 초기화
// 자연수가 소수로 나누어지지 않는다면, 소수 값을 1증가
// end

fun main() {
    println(primeFactorization(3))
}

fun primeFactorization(input: Int): List<Int> {
    var n = input
    var primeFactor = 2
    var result = mutableListOf<Int>()

    while (n > 1) {
        if (n % primeFactor == 0) {
            result.add(primeFactor)
            n /= primeFactor
        } else {
            primeFactor++
        }
    }

    return result
}
