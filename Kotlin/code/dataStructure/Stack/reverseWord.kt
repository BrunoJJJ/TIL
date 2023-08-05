//stack 활용
////문자열 input의 각 문자들 뒤집어서 반환하는 함수 
////ex1) reverseWord("hi") == "ih"
////ex2) reverseWord("easy") == "ysea"
fun main() {
    val s = MyStack()
    val input1 = "easy"
    var reverseStr = ""
    for (c in input1) {
        s.push(c)
    }
    for (i in 1..s.getSize()) {
        reverseStr += s.pop()
    }
		
		// index와 1부터 적어야하는 for문보다 while문을 돌리는 것이 stack과 queue의 자료 구조의 본질에 가까움
		while(s.size > 0) {
        str += s.pop()
    }


    println(reverseStr)
}

class MyStack {
    val stackList = mutableListOf<Char>()
    var top = 0

    fun push(input: Char) {
        stackList.add(input)
        top++
    }

    fun pop(): Char {
        return stackList.removeAt(stackList.size - 1)
        top--
    }

    fun getSize(): Int {
        return top
    }
}


// java stack library
import java.util.Stack

fun main() {
    val s = Stack<Char>() // 한 가지 type

    for (c in "easy") {
        s.push(c)
    }

    var str = ""
    while(s.size > 0) {
        str += s.pop()
    }

    println(str)
}

// 문장을 받음
// 문자열에서 각 문자를 반복
// space를 만나지 않으면 stack에 push               
// space를 만나면 stack의 저장된 모든 문자들을 pop해서 str에 저장 
// str에 " "을 추가해 줌                           
// 문장의 끝에 도달하면 지금까지 저장된 모든 문자들을 pop

import java.util.Stack

fun main() {
    val s = Stack<Char>()
    val str = "my name is k"
    var reverseStr = ""

    for (c in str) {
        if (c != ' ') {
            s.push(c)
        } else {
            while (s.size > 0) {
                reverseStr += s.pop()
            }
            reverseStr += " "
        }
    }
    while (!s.isEmpty()) {
        reverseStr += s.pop()
    }

    println(reverseStr)
}


// 간결하게
import java.util.Stack

fun main() {
    val input = "my name is k"
    var wordList = splitStr(input)
    println(wordList)
    println(eleToString(wordList))
}

// 문자열을 받아 split, reverse된 단어들을 list에 추가하는 함수
fun splitStr(input: String): List<Any> {
    val s = Stack<Char>()
    val strList = mutableListOf<Any>()
    var str = ""

    for (c in input) {
        if (c != ' ') {
            s.push(c)
        } else {
            while (s.size > 0) {
                str += s.pop()
            }
            strList.add(str)
            str = ""
        }
    }
    while (s.size > 0) {
        str += s.pop()
    }
    strList.add(str)
    return strList
}

// list의 요소들을 " "로 이어서 문장으로 반환하는 함수
fun eleToString(input: List<Any>): String {
    var result = ""

    for (i in 0 until input.size) {
        if (i < input.size - 1) {
            result += input[i].toString() + " "
        } else {
            result += input[i].toString()
        }
    }
    return result
}

// list의 요소들을 " "로 이어서 문장으로 반환하는 함수
// 간결하게 쓰기
return input.joinToString(" ", postfix = "")

// joinToString의 알고리즘 - input[0]부터 시작하여 앞쪽에 space를 넣어주면 조건문 없어도 됨
fun eleToString(input: List<Any>): String {
    var result = input[0]
    for (i in 1 until input.size) {
        result += " " + input[i].toString()
    }
    return result
