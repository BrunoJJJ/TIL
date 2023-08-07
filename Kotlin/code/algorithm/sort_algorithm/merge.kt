// mergesort

fun main() {
    var testList = listOf<Int>(3, 5, 4, 6, 8, 1, 7, 2)
    mergesort(testList)
}
fun mergesort(input: List<Int>): List<Int> {
    if (input.size <= 1) {
        return input
    }

    val mid = input.size / 2
    var left = input.subList(0, mid) // sublist 마지막 값은 포함안함 0 ~ mid-1까지
    var right = input.subList(mid, input.size)

    return merge(mergesort(left), mergesort(right))
}


fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var newList = mutableListOf<Int>()
    var leftIndex = 0
    var rightIndex = 0



    while (leftIndex < left.count() && rightIndex < right.count()) {
        if (left[leftIndex] >= right[rightIndex]) {
            newList.add(left[leftIndex])
            leftIndex++
        } else {
            newList.add(right[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < left.size) {
        newList.add(left[leftIndex])
        leftIndex++
    }

    while (rightIndex < right.size) {
        newList.add(right[rightIndex])
        rightIndex++
    }

    return newList
}

// 정복 시만 새로운 리스트에 정렬을 하고 분할 시 sublist없이 index로 구현하여 공간복잡도를 낮추게 해보기
