package problems.onlinkedlist;

public class SwapPairs {
    /**
     * source : leetcode
     * Swap Nodes in Pairs
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode senti = new ListNode(0);
        ListNode first = head;
        ListNode second = first != null ? first.next : first;
        senti.next = second != null ? second : first;
        ListNode cur = senti;

        while (first != null && second != null) {
            swap(cur, first, second);
            cur = first;
            first = first.next;
            second = first != null ? first.next : first;

        }
        return senti.next;
    }

    private void swap(ListNode cur, ListNode first, ListNode second) {
        ListNode temp = second.next;
        second.next = first;
        first.next = temp;
        cur.next = second;
    }
}
