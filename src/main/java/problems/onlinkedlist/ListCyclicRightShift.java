package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import edu.princeton.cs.algs4.In;

public class ListCyclicRightShift {
    public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L,
                                                             int k) {
        if (L == null ) return L;

        ListNode<Integer> dummyNode = new ListNode<>(0, L);
        ListNode<Integer> first = dummyNode.next;
        ListNode<Integer> second = dummyNode.next;

        int listLen = 0;
        while (first!=null){
            first=first.next;
            listLen++;
        }
        first = dummyNode.next;
        //K can be as large as million or more so as this is cyclic shift
        //Effective shift will be k modulo list length
        int effectiveShift = k % listLen;


        while (effectiveShift-- > 0) {
            second = second.next;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        //detach last k%listlength node of list and put them first so making
        //cyclic shift
        second.next = dummyNode.next;
        dummyNode.next = first.next;
        first.next = null;

        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

        L = cyclicallyRightShiftList(L, 1000000000); // node with data = 7
        System.out.println(L);
    }
}
