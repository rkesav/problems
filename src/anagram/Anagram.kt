package anagram

class Anagram {
    fun isAnagram(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Int>()

        for (c in s.toCharArray()) {
            val i = map[c]

            if (i == null) {
                map[c] = 1
            } else {
                map[c] = i + 1
            }

        }

        for (c in t.toCharArray()) {
            val i = map[c]

            if (i == null || i == 0) {
                return false
            } else {
                map[c] = i - 1
            }
        }

        for (value in map.values) {
            if (value != 0) {
                return false
            }
        }

        return true
    }
}

fun main() {

    val result = Anagram().isAnagram("cat", "rat")
    println(result)
}