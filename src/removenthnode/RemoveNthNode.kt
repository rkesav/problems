package removenthnode

class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return head
        }
        var cur = head
        var prev:ListNode? = null
        while (cur != null) {
            if(isNthFromLast(cur, n)) {
                if(prev == null) {
                    return cur.next
                }
                prev.next = cur.next
                return head
            }
            prev = cur
            cur = cur.next
        }
        return null
    }

    private fun isNthFromLast(node: ListNode, n: Int): Boolean {
        var i = 0
        var nthNode: ListNode? = node
        while (i < n) {
            nthNode = nthNode!!.next
            i++
        }
        if (nthNode == null) {
            return true
        }
        return false
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    //val result = RemoveNthNode().removeNthFromEnd("23")
    //println(result)
}