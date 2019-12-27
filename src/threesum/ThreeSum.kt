package threesum

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var result: MutableList<Set<Int>> = mutableListOf()

        var i = 0
        while (i < nums.size) {
            val sum = nums[i] * -1
            var j = 0
            var map = mutableMapOf<Int, Int>()
            while (j < nums.size) {
                if (j != i) {
                    map[sum - nums[j]] = nums[j]
                    if (map[nums[j]] != null) {
                        if ( !(result.contains(setOf(nums[i], nums[j], nums[j] * -1)))
                        ) {
                            result.add(setOf(nums[i], nums[j], map[nums[j]]!!))
                        }
                    }
                }
                j++
            }
            i++
        }
        var toReturn: MutableList<List<Int>> = mutableListOf()
        for (set in result) {
            toReturn.add(set.toList())
        }
        return toReturn
    }
}

fun main() {
    val result = ThreeSum().threeSum(arrayOf(-1, 0, 1, 2, -1, -4).toIntArray())
    println(result)
}