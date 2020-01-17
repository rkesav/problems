package maxgap

class MaxGap {
    fun maximumGap(nums: IntArray): Int {
        // Using buckets to get the max gap

        /*
        1. Get min and max of array
        2. Get bucket size b = [mix - min] / [n -1] . We choose this bucket size because this is the min bucket size possible when all elements are placed in equal width.
        3. Get number of buckets k = [max - min] / b
        4. Put elements in buckets - One iteration of array
        5. Find max gap between buckets
         */

        if (nums.size < 2) {
            return 0
        }

        val min = nums.min()!!
        val max = nums.max()!!

        if (nums.size == 2) {
            return max - min
        }

        val b = (max - min) / (nums.size - 1)

        val k = if ( b == 0) {
             1
        }
        else  ((max - min) / b)

        var buckets : Array<Array<Int>> = Array(k) { arrayOf(Int.MAX_VALUE , Int.MIN_VALUE)}
        var i = 0
        while (i < nums.size) {
            var ind =  if ( b == 0) {
                1
            } else ((nums[i] - min) / b)
            if ( ind != 0) ind--
            val pair = buckets[ind]

            if (nums[i] < pair[0]) {
                pair[0] = nums[i]
            }
            if (nums[i] > pair[1]) {
                pair[1] = nums[i]
            }
            buckets[ind] = pair
            i++
        }

        var validBuckets : MutableList<Array<Int>> = mutableListOf()
        var l = 0

        while (l < buckets.size) {
            if (!(buckets[l][0] == Int.MAX_VALUE && buckets[l][1] == Int.MIN_VALUE)) {
                validBuckets.add(buckets[l])
            }
            l++
        }

        if ( validBuckets.size == 1) {
            if (validBuckets[0][1] == Int.MIN_VALUE) {
                return validBuckets[0][0]
            } else {
                return validBuckets[0][1] - validBuckets[0][0]
            }
        }
        var j = 0
        var maxGap = 0
        while (j < validBuckets.size - 1) {
            val gap = validBuckets[j + 1][0] - validBuckets[j][1]
            if ( gap > maxGap) {
                maxGap = gap
            }
            j++
        }
        return maxGap
    }

}

fun main() {
    //val result = MaxGap().maximumGap(arrayOf(3, 6, 9, 1).toIntArray())
    val result = MaxGap().maximumGap(arrayOf(1,1,1,1,1,5,5,5,5,5).toIntArray())
    println(result)
}