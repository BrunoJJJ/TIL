fun main() {
    val input = listOf<Int>(5, 4, 2, 1, 3, 6, 8, 7)
    selectionSort(input)
}


// selection sort  최댓값 찾고 왼쪽 정렬
// input타입을 MutableList로 받는 것보다 함수 안에서 toMutableList()를 해주는 것이 더 안정적. 함수 안에서 쓰여지고 버려지기 때문
// MutableList는 List의 자식이라 List로 받을 수 있음. 반대는 불가능
fun selectionSort(input: List<Int>): List<Int> { 
    val mInput = input.toMutableList() 
    for (i in 0 until mInput.size) {
        var maxIndex = i
        for (j in i + 1 until mInput.size) {
            if (mInput[maxIndex] < mInput[j])
                maxIndex = j
        }

        val tmp = mInput[i]
        mInput[i] = mInput[maxIndex]
        mInput[maxIndex] = tmp


    }
    return mInput
}
