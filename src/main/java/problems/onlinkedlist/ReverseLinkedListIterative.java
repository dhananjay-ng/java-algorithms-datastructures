package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class ReverseLinkedListIterative {
    public static ListNode<Integer> reverseLinkedList(ListNode<Integer> head) {
        ListNode<Integer> prev = null, curr = head;
        while (curr != null) {
            ListNode<Integer> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(1, null);
        ListNode<Integer> l2 = new ListNode<>(2, null);
        l1.next = l2;
        ListNode<Integer> l3 = new ListNode<>(3, null);
        ListNode<Integer> l4 = new ListNode<>(4, null);
        l2.next = l3;
        l3.next=l4;
        System.out.println(l1);
        System.out.println(reverseLinkedList(l1));
    }
}
