package lettercombinations

class LetterCombinations {
    fun letterCombinations(digits: String): List<String> {

        if (digits.isBlank()) {
            return emptyList()
        }
        val map = mutableMapOf<Char, List<Char>>()
        map['2'] = listOf('a', 'b', 'c')
        map['3'] = listOf('d', 'e', 'f')
        map['4'] = listOf('g', 'h', 'i')
        map['5'] = listOf('j', 'k', 'l')
        map['6'] = listOf('m', 'n', 'o')
        map['7'] = listOf('p', 'q', 'r', 's')
        map['8'] = listOf('t', 'u', 'v')
        map['9'] = listOf('w', 'x', 'y', 'z')

        val result = mutableListOf<String>()
        return getCombo("", digits, 0, result, map)
    }

    private fun getCombo(
        str: String,
        digits: String,
        i: Int,
        result: MutableList<String>,
        map: MutableMap<Char, List<Char>>
    ): MutableList<String> {
        if(i >= digits.length) {
            result.add(str)
            return result
        }

        val listChar = map[digits[i]]
        for (c in listChar!!) {
            getCombo(str + c, digits, i + 1, result, map)
        }
        return result

    }
}

fun main() {
    val result = LetterCombinations().letterCombinations("23")
    println(result)
}