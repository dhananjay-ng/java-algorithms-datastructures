package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class DeleteKthLastFromList {

    // Assumes L has at least k nodes, deletes the k-th last node in L.
    public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
        //Whenever we want to preserve head node for returning keep track of
        //dummyHead node, helps in lot's of null check
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> first = dummyHead.next;
        while (k-- > 0) {
            first = first.next;
        }
        ListNode<Integer> second = dummyHead;

        while (first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

        L = removeKthLast(L, 1); // node with data = 7
        System.out.println(L);
    }

}
