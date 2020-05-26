package fb;

public class MergeSortedLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode sortedList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode curList = lists[i];
            ListNode list1Pointer = sortedList;
            ListNode list2Pointer = curList;
            ListNode mergedList = new ListNode(-1, null);
            ListNode mergedListHead = mergedList;
            while(list1Pointer != null && list2Pointer != null) {
                if (list1Pointer.val < list2Pointer.val) {
                    mergedList.next = list1Pointer;
                    list1Pointer = list1Pointer.next;
                } else {
                    mergedList.next = list2Pointer;
                    list2Pointer = list2Pointer.next;
                }
                mergedList = mergedList.next;
            }
            while (list1Pointer != null) {
                mergedList.next = list1Pointer;
                list1Pointer = list1Pointer.next;
                mergedList = mergedList.next;
            }
            while (list2Pointer != null) {
                mergedList.next = list2Pointer;
                list2Pointer = list2Pointer.next;
                mergedList = mergedList.next;
            }
            sortedList = mergedListHead.next;
        }
        return sortedList;
    }
}
