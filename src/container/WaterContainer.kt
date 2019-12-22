package container

import kotlin.math.min

class WaterContainer {
    fun maxArea(height: IntArray): Int {

        var i = 0
        var j = height.size - 1
        var mA = 0

        while (i <= j) {
            val thisArea = kotlin.math.min(height[i], height[j]) * (j-i)
            if (thisArea > mA) mA = thisArea

            val compareTo = height[i].compareTo(height[j])
            when (compareTo) {
                -1 -> i++
                1 -> j--
                0 -> {i++; j--}
            }
        }
        return mA
    }

}

fun main() {
    val maxArea = WaterContainer().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
    println(maxArea)
}