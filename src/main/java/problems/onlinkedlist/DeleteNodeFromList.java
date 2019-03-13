package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class DeleteNodeFromList {

    public static void deletionFromList(ListNode<Integer> nodeToDelete) {
        if (nodeToDelete.next == null){
            nodeToDelete = null;
            return;
        }
        ListNode<Integer> toDelete = nodeToDelete.next;
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
        toDelete = null;
        return;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

        deletionFromList(L.next);//3
        System.out.println(L);

    }

}
