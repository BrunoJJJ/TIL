// 미완 시도 중

fun main() {

}

class MinHeap {
    val heapList = mutableListOf<Int>(0) // 0번째 값 채워넣음, 사용하지 않음.

    fun insert(input: Int) {
        heapList.add(input)
        shiftUp(heapList.size - 1)
    }

    fun remove(): Int {
        val minValue = heapList[1]
        heapList[1] = heapList[heapList.size - 1]
        heapList.removeAt(1)
        return minValue
    }

    fun shiftUp(index: Int) {
        var currentIndex = index

        while (currentIndex > 0) {
            val parentIndex = currentIndex / 2
            if (heapList[currentIndex] > heapList[parentIndex]) {
                var tmp = 0
                tmp = heapList[parentIndex]
                heapList[parentIndex] = heapList[currentIndex]
                heapList[currentIndex] = tmp
            } else {
                break
            }
        }
    }
}
