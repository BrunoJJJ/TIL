val gradeMap = mapOf<String, Float>(
    "A+" to 4.3f,
    "A" to 4.0f,
    "A-" to 3.7f,
    "B+" to 3.3f,
    "B" to 3.0f,
    "B-" to 2.7f,
    "C+" to 2.3f,
    "C" to 2.0f,
    "C-" to 1.7f,
    "D+" to 1.3f,
    "D" to 1.0f,
    "D-" to 0.7f,
    "F" to 0.0f
)

// 학점을 숫자로 전환하는 함수
fun gradeConvertScore(grade: String): Float? {
    return gradeMap[grade]
}

// 학점 map의 평균 계산 함수
fun calcGradeAvg(gradeMap: Map<String, Float>): Float {
    var sum = 0f

    for (value in gradeMap.values) {
        sum += value
    }

    return sum/gradeMap.size
}


// student class 설계
class Student(var name: String, var score: Int) {
    init {
        println("name : $name, score : $score")
    }
}

fun main() {
		println(gradeConvertScore("C-"))
    println(calcGradeAvg(gradeMap))


// 10명의 학생의 점수를 추가하고 등수 계산 ing
		var student1 = Student("Liam", 98)
    var student2 = Student("Noah", 97)
    var student3 = Student("Oliver", 96)
    var student4 = Student("Wiliam", 95)
    var student5 = Student("Elijah", 94)
    var student6 = Student("James", 93)
    var student7 = Student("Benjamin", 92)
    var student8 = Student("Lucas", 91)
    var student9 = Student("Mason", 90)
    var student10 = Student("Ethan", 89)

		var scores = listOf(
        student1.score,
        student2.score,
        student3.score,
        student4.score,
        student5.score,
        student6.score,
        student7.score,
        student8.score,
        student9.score,
        student10.score
    )

    println("1st score : ${scores.max()}")
}

