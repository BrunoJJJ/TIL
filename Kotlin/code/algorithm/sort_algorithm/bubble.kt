fun bubbleSort(input: List<Int>): List<Int> {
    val mInput = input.toMutableList()
    for (i in 1..mInput.size) {
        for (j in 0 until mInput.size - 1) { // list size만큼 반복
            if (mInput[j] < mInput[j + 1]) {
                var tmp = mInput[j]
                mInput[j] = mInput[j + 1]
                mInput[j + 1] = tmp
            }
        }
    }
    return mInput
}

// cf. 정렬된 부분까지 버블 정렬 중. 계단식으로 정렬된 부분은 돌지 않게끔 구현하기
