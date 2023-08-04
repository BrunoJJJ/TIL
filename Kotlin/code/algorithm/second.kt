// 1
fun main() {
    println(second(listOf(5, 3, 7, 1))) // 5
    println(second(listOf(-1, -5, 3, -10))) // -1


}

fun second(input: List<Int>): Int {
    return input.sorted().reversed()[1] // list는 sorted, reversed() 함수 사용. mutableList는 .sort(), reverse() 바로 적용
} 

// 2
// pseudo code
// start
// 변수 a 선언
// input의 가장 큰 값을 a에 초기화
// input을 mutableList인 input2로 변환
// input2에서 a를 제거
// input2의 가장 큰 값을 반환
// end

fun main() {
    println(second(listOf(5, 3, 7, 1))) // 5
    println(second(listOf(-1, -5, 3, -10))) // -1
}

fun second(input: List<Int>): Int {
    var a = 0
    a = input.max()

    val input2 = input.toMutableList()
    input2.remove(a)

    return input2.max()
}

// 3
// 가장 최댓값
// start
// maxValue에 list x번째 인덱스 값을 초기화 ( x = 0 )
// list의 길이만큼 반복
// list (x+1)번째 값 비교
// list (x+1) 값이 크면 maxValue의 값을 list (x+1) 값으로 초기화
// maxvalue 반환
// end

fun second(input: List<Int>): Int {
    var maxValue = input[0]
    for (i in 1 until input.size) {
        if (maxValue < input[i]) {
            maxValue = input[i]
        }
    }
    return maxValue
}

// 활용 두번째 큰 값
fun second(input: List<Int>): Int {
    var maxValue = input[0]
    var secondValue = 0
    for (i in 1 until input.size) {
        if (maxValue < input[i]) {
            secondValue = maxValue
            maxValue = input[i]
        }
    }
    return secondValue
}
