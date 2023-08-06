//괄호문자열의 구성이 올바른지 판단하는 함수
//ex) checkPS("(45454)") == true
//ex) checkPS("()()") == true
//ex) checkPS("(())()") == true

// 1
import java.util.Stack

fun main() {
    println(checkPS("(45454)"))
    println(checkPS("()(45454)"))
    println(checkPS("(((45454)))()"))

}

fun checkPS(input: String): Boolean {
    val s = Stack<Char>()
    
    for (i in input.indices) {
        s.push(input[i])
        if (s.peek() == ')') {
            for (j in 1 .. s.size) {
                s.pop()
                if (s.peek() == '(') {
                    s.pop()
                    break
                }
            }
        }
    }
    return s.isEmpty()
}


// 2
// for문 하나로 해결해보기
import java.util.Stack

fun main() {
    println(checkPS("))(("))
    println(checkPS("(45454)"))
    println(checkPS("()(45454)"))
    println(checkPS("(((45454)))()"))

}

fun checkPS(input: String): Boolean {
    val s = Stack<Char>()
    var cnt1 = 0
    var cnt2 = 0

    for (i in input.indices) {
        s.push(input[i])
        if (s.peek() == '('){
            cnt1++
        } else if (s.peek() == ')') {
            cnt2++
        }
        if (cnt1 < cnt2) {
            return false
        }
    }
    return cnt1 == cnt2
}


// 3
// + 중괄호, 대괄호
import java.util.Stack

fun main() {
    println(checkPS("{}"))
    println(checkPS("[]"))
    println(checkPS("]["))
    println(checkPS("()"))
    println(checkPS("[(){}]"))
    println(checkPS("[({)}]"))
    println(checkPS("([]{[]}[])"))
    println(checkPS("[({)}]"))


}

fun checkPS(input: String): Boolean {
    val s = Stack<Char>()
    var sCnt = 0   // (
//    var sEndCnt = 0     // )
    var mCnt = 0   // {
//    var mEndCnt = 0     // }
    var lCnt = 0   // [
//    var lEndCnt = 0     // ]

    for (i in input.indices) {
        s.push(input[i])
        // 소 중 대 괄호의 열림, 닫힘에 따라 cnt++
				// 열린 괄호 다음에 매칭되지 않는 닫힌 괄호가 오면 false (한계 : 바로 다음 index만 비교함..)
        when {
            s.peek() == '(' -> {
                if (input[i + 1] == '}' || input[i + 1] == ']') {
                    return false
                }
                sCnt++
            }
            s.peek() == ')' -> {
                sCnt--
            }
            s.peek() == '{' -> {
                if (input[i + 1] == ')' || input[i + 1] == ']') {
                    return false
                }
                mCnt++
            }
            s.peek() == '}' -> {
                mCnt--
            }
            s.peek() == '[' -> {
                if (input[i + 1] == ')' || input[i + 1] == '}') {
                    return false
                }
                lCnt++
            }
            s.peek() == ']' -> {
                lCnt--
            }
        }
        // 닫힘이 열림의 개수 보다 많을 때 false
        if (sCnt < 0 || mCnt < 0 || lCnt < 0) {
            return false
        }
    }

    return (sCnt == 0 && mCnt == 0 && lCnt == 0)
}


// 4
// peek 없이 pop으로도 충분하다고 함
import java.util.Stack

fun main() {
    println(checkPS("{}"))
    println(checkPS("[]"))
    println(checkPS("]["))
    println(checkPS("()"))
    println(checkPS("[(){}]"))
    println(checkPS("[({)}]"))
    println(checkPS("([]{[]}[])"))
    println(checkPS("[({3)}]"))
}

fun checkPS(input: String): Boolean {
    val s = Stack<Char>()

    for (ch in input) {
        if (ch == '(' || ch == '{' || ch == '[') {
            s.push(ch)
        } else if (ch == ')') {
            if (s.isEmpty() || s.pop() != '(') {
                return false
            }
        } else if (ch == '}') {
            if (s.isEmpty() || s.pop() != '{') {
                return false
            }
        } else if (ch == ']') {
            if (s.isEmpty() || s.pop() != '[') {
                return false
            }
        }

//        when (ch) {
//            '(', '{', '[' -> {
//                s.push(ch)
//            }
//            ')' -> {
//                if (s.isEmpty() || s.pop() != '(') {
//                    return false
//                }
//            }
//            '}' -> {
//                if (s.isEmpty() || s.pop() != '{') {
//                    return false
//                }
//            }
//            ']' -> {
//                if (s.isEmpty() || s.pop() != '[') {
//                    return false
//                }
//            }
//        }
    }

    return s.isEmpty()
}
