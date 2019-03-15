package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import edu.princeton.cs.algs4.In;


public class ReverseSublist {

    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                   int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> subListStart = dummyHead;
        for (int i = 1; i < start; i++)
            subListStart = subListStart.next;

        // this will node will get shifted from start position to finish
        // and also act as itrator for list
        ListNode<Integer> listIterator = subListStart.next;
        for (int k = start; k < finish; k++) {
            //this code puts next node of iterator at the start of sublist
            //making sublist reverse.
            ListNode<Integer> detachedNode = listIterator.next;
            listIterator.next = detachedNode.next;
            detachedNode.next = subListStart.next;
            subListStart.next = detachedNode;
        }
        return dummyHead.next;
    }

    public static void reverseFromNode(ListNode<Integer> node) {
        if (node == null || node.next == null) return;
        ListNode<Integer> listIter = node.next;
        while (listIter != null && listIter.next!=null) {
            ListNode<Integer> detachNode = listIter.next;
            listIter.next = detachNode.next;
            detachNode.next = node.next;
            node.next = detachNode;
        }
        return;
    }

    public static ListNode<Integer> reverseSublist2(ListNode<Integer> L, int start,
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
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

        L = reverseSublist(L, 2, 4);
        System.out.println(L.toString());

    }
}
