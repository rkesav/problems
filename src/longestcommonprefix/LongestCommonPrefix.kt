package longestcommonprefix

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        var i = 0

        var maxPre = ""
        while (i < strs[0].length) {
            var j = 1
            while (j < strs.size) {
                if ( strs[j].length <= i || strs[j][i] != strs[0][i]) {
                    return maxPre
                }
                j++
            }
            maxPre = strs[0].substring(0, i+1)
            i++
        }
        return strs[0]
    }

    fun longestCommonSub(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }
        var thisStr = strs[0]

        var i = 1
        var result = ""
        while (i < strs.size) {
            var maxL = 0
            var maxSub = ""
            var j = 0
            val str = strs[i]
            while (j < thisStr.length) {
                var k = j + 1
                while (k <= thisStr.length) {
                    if (str.contains(thisStr.subSequence(j, k))) {
                        val len = k - j
                        if (len > maxL) {
                            maxL++
                            maxSub = thisStr.subSequence(j, k).toString()
                        }
                    } else {
                        break
                    }
                    k++
                }
                j++
            }
            if (maxSub == "") {
                return ""
            } else {
                thisStr = maxSub
                result = maxSub
            }
            i++
        }
        return result
    }
}

fun main() {
        val string = LongestCommonPrefix().longestCommonPrefix(arrayOf("ca", "a"))
        println(string)
}