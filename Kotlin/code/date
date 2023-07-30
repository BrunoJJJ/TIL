import java.time.LocalDate
import java.time.Period

fun calculateAge(birth: LocalDate): Int {
    val today = LocalDate.now()

    val period = Period.between(birth, today)

    return period.years
    
		//if 월, 일이 지나기 전 age - 1 작성
    //val months = period.months
    //val days = period.days
}

fun main() {
    val birth = LocalDate.of(1998, 1, 20)
    println(calculateAge(birth))
}
