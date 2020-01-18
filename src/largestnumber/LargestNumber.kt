package largestnumber

class LargestNumber {

    fun largestNumber(nums: IntArray): String {
        val map = mutableMapOf<Int, IntArray>()

        // Implement comparator by concatenating two number string in both orders and comparing each other
        return ""
    }
}

fun main() {
    //val result = MaxGap().maximumGap(arrayOf(3, 6, 9, 1).toIntArray())
    val result = LargestNumber().largestNumber(arrayOf(1,1,1,1,1,5,5,5,5,5).toIntArray())
    println(result)
}