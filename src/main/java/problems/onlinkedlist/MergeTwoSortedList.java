package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class MergeTwoSortedList {
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                        ListNode<Integer> L2) {
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;

        while (L1 != null && L2 != null) {
            if (L1.data < L2.data) {
                current.next = L1;
                L1 = L1.next;
            } else {
                current.next = L2;
                L2 = L2.next;
            }
            current = current.next;

        }
        current.next = L1 == null ? L2 : L1;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L1;
        ListNode<Integer> L2;
        L1 = new ListNode<>(1,new ListNode<>(3,new ListNode<>(5,null)));
        L2 =new ListNode<>(2,new ListNode<>(4,new ListNode<>(6,null)));
        System.out.println(mergeTwoSortedLists(L1,L2).toString());

    }
}

