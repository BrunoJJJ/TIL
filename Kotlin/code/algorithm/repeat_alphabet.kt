// pseudo code
// start
// 반환 값으로 문자열 answer 선언
// input의 인덱스 값 범위 만큼 반복
// n만큼 반복
// answer 값에 input의 인덱스 값에 해당하는 문자를 추가
// answer 문자열 반환
// end

fun main() {
    println(repeatAlphabet("hi", 2))
}

fun repeatAlphabet(input:String, n: Int): String {
    var answer: String = ""

    for (i in 0..input.length - 1) { // index 이용
        for (j in 1..n) {
            answer += input[i]
        }
    } 
    return answer
}

/* 문자열 이용
for (c in input) { 
        for (j in 1..n) {
            answer += c
        }
    }
*/

// 람다식 이용
// input.forEach { c -> for (j in 1..n) {answer += c} }
