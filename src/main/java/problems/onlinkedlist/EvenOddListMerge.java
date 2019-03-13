package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class EvenOddListMerge {

    //Even position odd position element assembly
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
        if (L == null) {
            return L;
        }

        ListNode<Integer> evenDummyHead = new ListNode<>(0, null),
                oddDummyHead = new ListNode<>(0, null);
        ListNode<Integer> evenIterator = evenDummyHead;
        ListNode<Integer> oddIterator = oddDummyHead;
        int turn = 0;
        for (ListNode<Integer> iter = L; iter != null; iter = iter.next) {
            if (turn==0){
                evenIterator.next = iter;
                evenIterator = evenIterator.next;
            }else {
                oddIterator.next = iter;
                oddIterator = oddIterator.next;
            }
            turn ^= 1;  //toggle between even mode and odd mode.
        }
        oddIterator.next = null;
        evenIterator.next = oddDummyHead.next;
        return evenDummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(4, new ListNode<>(2, null)))));

        L = evenOddMerge(L); // node with data = 7
        System.out.println(L);
    }
}
