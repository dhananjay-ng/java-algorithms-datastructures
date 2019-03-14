package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class ListPivoting {
    public static ListNode<Integer> listPivoting(ListNode<Integer> l, int x) {
        ListNode<Integer> lessHead = new ListNode<>(0,null);
        ListNode<Integer> equalHead = new ListNode<>(0,null);
        ListNode<Integer> greaterHead = new ListNode<>(0,null);;

        ListNode<Integer> lessIter = lessHead;
        ListNode<Integer> equalIter = equalHead;
        ListNode<Integer> greaterIter = greaterHead;
        ListNode<Integer> iter = l;


        while (iter !=null) {
            if (iter.data<x){
                lessIter.next = iter;
                lessIter = lessIter.next;
            } else if (iter.data == x) {
                equalIter.next = iter;
                equalIter = equalIter.next;
            } else if (iter.data > x ){
                greaterIter.next = iter;
                greaterIter = greaterIter.next;
            }
            iter = iter.next;
        }
        greaterIter.next = null;
        equalIter.next = greaterHead.next;
        lessIter.next = equalHead.next;

        return lessHead.next;

    }

    public static void main(String[] args) {

        ListNode<Integer> L;
        L = new ListNode<>(5,
            new ListNode<>(4,
            new ListNode<>(2,
            new ListNode<>(2,
            new ListNode<>(1,
            new ListNode<>(1,null))))));

        L=listPivoting(L,1);
        System.out.println(L);

    }
}
