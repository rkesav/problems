package roman

class Roman {
    fun roman(num: Int): String {
        val chars = num.toString().toCharArray()
        var i = chars.size - 1
        var pos = 1

        var string = ""

        while (i >=0) {
            var triple: Triple<Char, Char, Char> = Triple('I', 'I', 'I')
            when (pos) {
                1 -> {
                    triple = Triple('I', 'V', 'X')
                }
                2 -> {
                    triple = Triple('X', 'L', 'C')
                }
                3 -> {
                    triple = Triple('C', 'D', 'M')
                }
                4 -> {
                    triple = Triple('M', 'M', 'M')
                }
            }

            val thisNum = chars[i].toString().toInt()
            var thisStr = ""
            when {
                thisNum <= 3 -> {
                    var j = 0
                    while (j < thisNum) {
                        thisStr += triple.first
                        j++
                    }
                }
                thisNum <= 4 -> thisStr = thisStr + triple.first + triple.second
                thisNum <= 5 -> thisStr += triple.second
                thisNum <= 8 -> {
                    var j = 0
                    thisStr += triple.second
                    while (j < thisNum - 5) {
                        thisStr += triple.first
                        j++
                    }
                }
                thisNum <= 9 -> thisStr = thisStr + triple.first + triple.third
            }
            string = thisStr + string
            i--
            pos++
        }
        return string
    }
}

fun main() {
    val string = Roman().roman(1994)
    println(string)
}