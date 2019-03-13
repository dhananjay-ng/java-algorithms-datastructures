package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        while (L != null && L.next != null) {
            if (L.data == L.next.data) {
                L.next = L.next.next;
            } else {
                L = L.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(2, new ListNode<>(3,
                new ListNode<>(3, new ListNode<>(4, new ListNode<>(4, null)))));

        L = removeDuplicates(new ListNode<>(2,null)); // node with data = 7
        System.out.println(L);
    }

}
