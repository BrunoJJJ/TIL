// 1번 실행될 때, 제일 앞에 있는 단어 카드는 버리고 다음 카드를 제일마지막으로 옮긴다. (큐 활용)
// N이 주어졌을 때 제일 앞의 카드의 알파벳을 반화하는 함수
//
//1 <= N <= 26
//ex1) mixAlphabet(1) == 'c'
//ex1) mixAlphabet(3) == 'g'

fun main() {
    println(mixAlphabet(1))
    println(mixAlphabet(3))
}

fun mixAlphabet(input: Int): Char {
    val alphabetlist = listOf<Char>(
        'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    )
    val q = MyQueue()
    for (c in alphabetlist) {
        q.enqueue(c)
    }
    for (i in 1 .. input) {
        q.dequeue()
        q.enqueue(q.dequeue())
    }
    return q.dequeue()
}


class MyQueue() {
    val myList = mutableListOf<Char>()

    fun enqueue(input: Char) {
        myList.add(input)
    }
    fun dequeue(): Char {
        return myList.removeAt(0)
    }
    fun peek(): Char {
        return myList[0]
    }
}
