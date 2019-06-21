package problems.onsorting;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
          ListNode listNode = this;
          StringBuilder stringBuilder = new StringBuilder();
          while (listNode!=null){
              stringBuilder.append(listNode.val).append("->");
              listNode=listNode.next;
          }
          stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
          return stringBuilder.toString();
    }
}
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode iter = head;
        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else{
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if(l1!=null) {
            iter.next = l1;
        } else if(l2!=null){
            iter.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next=l2;
        l2.next=l3;

        l4.next=l5;
        l5.next=l6;

        System.out.println(mergeTwoLists(l1, l4));

    }
}
