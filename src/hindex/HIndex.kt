package hindex

class HIndex {
    fun hIndex(citations: IntArray): Int {

        if (citations.isEmpty()) return 0

        citations.sortDescending()

        var i = 0

        while (i < citations.size) {
            if (citations[i] < i+1) {
                break
            }
            i++
        }

        return i
    }
}