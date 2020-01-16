package listsort

class ListSort {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var pivot = head

        var sortedHead = quickSort(pivot)
        var head1 = sortedHead
        var head2 = pivot.next
        pivot.next = null

        val first = sortList(head1)
        val mid = sortList(head2)

        return join(first, mid)
    }

    private fun quickSort(pivot: ListNode?): ListNode? {
        if (pivot == null) {
            return pivot
        }

        var sortedHead: ListNode? = pivot

        var cur = pivot.next
        pivot.next = null

        var last = pivot
        while (cur != null) {
            var next = cur.next
            if (cur.`val` < pivot.`val`) {
                cur.next = sortedHead
                sortedHead = cur
            } else {
                last!!.next = cur
                cur.next = null
                last = cur
            }
            cur = next
        }
        return sortedHead
    }

    private fun join(first: ListNode?, mid: ListNode?): ListNode? {
        if (first == null) {
            return mid
        }
        if (mid == null) {
            return first
        }

        var cur = first

        while (cur!!.next != null) {
            cur = cur.next
        }

        cur.next = mid

        return first
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(4)
    val node1 = ListNode(19)
    head.next = node1
    val node2 = ListNode(14)
    node1.next = node2
    val node3 = ListNode(5)
    node2.next = node3
    val node4 = ListNode(-3)
    node3.next = node4
    val node5 = ListNode(1)
    node4.next = node5
    val node6 = ListNode(8)
    node5.next = node6
    val node7 = ListNode(5)
    node6.next = node7
    val result = ListSort().sortList(head)
    println(result)
}