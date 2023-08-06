fun insertionSort(input: List<Int>): List<Int> {
    val mInput = input.toMutableList()
    for (i in 1 until mInput.size) {
        var tmp = mInput[i]
        var j = i - 1
        while (j >= 0 && tmp > mInput[j]){
            mInput[j + 1] = mInput[j]
            j--
        }
        mInput[j + 1] = tmp
    }
    return mInput
}

// for문은 자료구조와 어울리지 않음.
// bubble정렬처럼 자꾸 구현하려고 했음.
