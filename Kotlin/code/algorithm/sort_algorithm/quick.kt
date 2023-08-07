fun main() {
    val list = listOf<Int>(5, 3, 1, 8, 6, 4, 7, 2)
    println(quickSort(list))
}

fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) {
        return list
    }
    
    val muList = list.toMutableList()
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    val pivotList = mutableListOf<Int>()
    var pivot = muList[muList.size / 2]
    

    for (i in 0 until muList.size) { // n만큼 반복
        if (muList[i] > pivot) {
            leftList.add(muList[i])
        } else if (muList[i] < pivot) {
            rightList.add(muList[i])
        } else {
            pivotList.add(muList[i])
        }
    }

    return quickSort(leftList) + pivotList + quickSort(rightList)
}
//cf. list 생성하지 않고 index로 해결 방법 찾아보기

// ps.
// if (list.size < 2) {
//         return list
//     }
// 부분을 
// var pivot = muList[muList.size / 2]
// 보다 아래 썼더니 muList.size가 0, 1일 경우에
// 무한 루프에 빠지면서 에러.. 앞쪽에 list.size를 먼저 검사


// gpt
fun <T : Comparable<T>> quickSort(list: List<T>): List<T> {
    if (list.size <= 1) {
        return list
    }

    val pivot = list[list.size / 2]
    val (less, equal, greater) = list.partition { it < pivot }

    return quickSort(less) + equal + quickSort(greater)
}

// partition함수 배움. 3개 값이 나뉘는지? 안되면 2가지로 분리 후 listOf(pivot)







