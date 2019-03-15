package problems.onlinkedlist.gfg;

import datastructures.linkedlist.Node;

public class ReorderList {
    static Node reorderList(Node node)
    {
        Node head = node;
        if (head == null || head.next == null) return head;
        Node dummyHead = new Node(0,head);

        int listlen = 0;
        while (head!=null){
            head = head.next;
            listlen++;
        }
        Node subListStart = dummyHead;
        for (int i = 0; i < (listlen/2); i++)
            subListStart = subListStart.next;

        // reverse second part
        // this will node will get shifted from start position to finish
        // and also act as itrator for list
        Node listIterator = subListStart.next;
        for (int k = listlen/2; k < listlen-1; k++) {
            //this code puts next node of iterator at the start of sublist
            //making sublist reverse.
            Node detachedNode = listIterator.next;
            listIterator.next = detachedNode.next;
            detachedNode.next = subListStart.next;
            subListStart.next = detachedNode;
        }
        subListStart = subListStart.next;
        head = dummyHead.next;
        Node stop = subListStart;
        Node reorderd = dummyHead;
        while (head !=stop && subListStart!=null){
            reorderd.next = head;
            head = head.next;    //If we place this below order will get changed

            reorderd.next.next = subListStart;
            subListStart = subListStart.next;

            reorderd = reorderd.next.next;

        }
        return dummyHead.next;

    }
    public static void main(String[] args) {
        Node L;
        L = new Node(1, new Node(2,
                new Node(3, new Node(4, new Node(5, null)))));


        System.out.println(reorderList(L));


    }
}
