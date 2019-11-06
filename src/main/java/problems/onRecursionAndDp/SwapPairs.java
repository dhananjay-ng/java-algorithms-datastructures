package problems.onRecursionAndDp;

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
        if (head == null) return head;
        return pairsSwap(head, head.next);
    }
    private ListNode pairsSwap(ListNode first, ListNode second) {
        if(first == null || second == null) return first;
        if(second.next == null) {
            second.next = first;
            first.next = null;
            return second;
        }
        first.next = pairsSwap(second.next, second.next.next);
        second.next = first;
        return second;
    }
}
