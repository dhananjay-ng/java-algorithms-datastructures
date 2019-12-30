package problems.patterns.onlinkedlistreversal;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
      if (head == null || head.next == null) return head;

      ListNode prev = null;
      ListNode cur = head;

      while (cur != null) {
          ListNode rest = cur.next;
          cur.next = prev;
          prev = cur;
          cur = rest;
      }
      return prev;
    }
    public static ListNode reverse(ListNode head, int p, int q) {
        if (head == null || head.next == null) return head;
        if (p == 1 && q == 1) return head;
        int cnt = 1;
        ListNode rethead = head;
        ListNode prevh = null;

        while (cnt!=p) {
            prevh = head;
            head = head.next;
            cnt++;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode rest = cur.next;
        ListNode temphead = head;
        while (cnt<= q && cur != null) {
            rest = cur.next;
            cur.next = prev;
            prev = cur;
            cur = rest;
            cnt++;
        }
        prevh.next = prev;
        temphead.next = rest;
        return prevh;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

      //  ListNode result = ReverseLinkedList.reverse(head);
        ListNode result = ReverseLinkedList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}