package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;


public class ReverseSublist {

    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                   int finish) {
        ListNode<Integer> startNode;
        ListNode<Integer> endNode;
        ListNode<Integer> prev;
        ListNode<Integer> next;
        ListNode<Integer> temp = null;
        ListNode<Integer> head = L;
        if (L == null || start == finish) return L;

        for (int i = 1; i < start - 1; i++)
            L = L.next;

        startNode = L;
        if (start == 1) {
            endNode = L;
            prev = L;
        } else {
            endNode = L.next;
            prev = L.next;
        }
        next = prev.next;
        for (int i = start; i < finish; i++) {
            temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        startNode.next = prev;
        endNode.next = temp;

        if (start == 1) head = prev;

        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11,new ListNode<>(3,
                new ListNode<>(5,new ListNode<>(7,new ListNode<>(2,null)))));

        L=reverseSublist(L,1,2);
        System.out.println(L.toString());

    }
}
