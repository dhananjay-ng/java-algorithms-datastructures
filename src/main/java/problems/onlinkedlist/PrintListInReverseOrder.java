package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class PrintListInReverseOrder {
    static StringBuilder res = new StringBuilder();

    //recursive solution
    public static void reversePrint(ListNode<Integer> node) {
        if (node == null){
            return;
        }
        reversePrint(node.next);
        res.append(node.data).append("->");
    }
    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(3, new ListNode<>(12, null)))));

        reversePrint(L);
        System.out.println(res.delete(res.length()-2,res.length()));
    }
}

