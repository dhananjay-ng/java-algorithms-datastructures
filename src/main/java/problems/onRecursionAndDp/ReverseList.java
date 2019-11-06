package problems.onRecursionAndDp;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode senti = new ListNode(-1);
        reverse(head, senti);
        head.next = null;
        return senti.next;
    }

    public static ListNode reverse(ListNode head, ListNode senti) {
        if (head == null) return null;
        ListNode c = reverse(head.next, senti);
        if (c != null) {
            c.next = head;
        } else {
            senti.next = head;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        two.next = null;

        reverseList(head);
    }
}
