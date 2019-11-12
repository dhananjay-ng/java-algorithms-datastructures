package problems.onRecursionAndDp;

public class MergeTwoSortedListsRec {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        merge(l1, l2, head);
        return temp.next;
    }

    public ListNode merge(ListNode l1, ListNode l2, ListNode sorted) {
        if (l1 == null && l2 == null) {
            sorted.next = null;
            return sorted;
        } else if (l1 == null) {
            sorted.next = l2;
            return sorted;
        } else if (l2 == null) {
            sorted.next = l1;
            return sorted;
        }
        if (l1.val <= l2.val) {
            sorted.next = l1;
            l1 = l1.next;
        } else {
            sorted.next = l2;
            l2 = l2.next;
        }
        sorted = sorted.next;
        return merge(l1, l2, sorted);
    }
}
