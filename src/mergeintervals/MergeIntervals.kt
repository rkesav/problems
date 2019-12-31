package mergeintervals

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        intervals.sortBy { it[1] }
        intervals.sortBy { it[0] }

        if (intervals.isEmpty() || intervals.size == 1) {
            return intervals
        }

        var i = 1
        var cur = intervals[0]

        val result = mutableListOf<IntArray>()
        while (i < intervals.size) {
            if (cur[1] < intervals[i][0])  {

                result.add(cur)
                cur = intervals[i]

                i++
                continue
            }
            if ((cur[1] > intervals[i][0]) && cur[1] >= intervals[i][1]) {
                cur = arrayOf(cur[0], cur[1]).toIntArray()

                i++
                continue
            }
            if ((cur[1] > intervals[i][0]) && cur[1] < intervals[i][1]) {
                cur = arrayOf(cur[0], intervals[i][1]).toIntArray()

                i++
                continue
            }
            if ((cur[1] == intervals[i][0])) {
                cur = arrayOf(cur[0], intervals[i][1]).toIntArray()

                i++
                continue
            }
        }
        result.add(cur)
        return result.toTypedArray()
    }
}

fun main() {
    val result = MergeIntervals().merge(arrayOf(
        intArrayOf(2,3),
        intArrayOf(2,2),
        intArrayOf(3,3),
        intArrayOf(1,3),
        intArrayOf(5,7),
        intArrayOf(2,2),
        intArrayOf(4,6)))
    for (ints in result) {
        println(ints)
    }
}