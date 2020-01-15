package insertionsort

class InsertionSort {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        var newHead: ListNode? = null
        var cur = head

        while (cur != null) {
            var newCur:ListNode? = newHead
            if (newCur == null || cur.`val` <= newCur.`val`) {
                val newNode = ListNode(cur.`val`)
                newNode.next = newCur
                newHead = newNode
                cur = cur.next
                continue
            }

            var prev = newCur
            newCur = newCur.next
            var flag = false
            while (newCur != null) {
                if (cur!!.`val` < newCur.`val`) {
                    val newNode = ListNode(cur.`val`)
                    newNode.next = newCur
                    prev!!.next = newNode
                    flag = true
                    break
                }
                prev = newCur
                newCur = newCur.next
            }

            if(!flag) {
                val newNode = ListNode(cur.`val`)
                prev!!.next = newNode

            }
            cur = cur.next
        }

        return newHead

    }
}

class ListNode(var `val`: Int) {
         var next: ListNode? = null
}

fun main() {
    val head = ListNode(-1)
    val node1 = ListNode(5)
    head.next = node1
    val node2 = ListNode(3)
    node1.next = node2
    val node3 = ListNode(4)
    node2.next = node3
    val node4 = ListNode(0)
    node3.next = node4
    val result = InsertionSort().insertionSortList(head)
    println(result)
}