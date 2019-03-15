package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import edu.princeton.cs.algs4.In;

import java.util.Deque;
import java.util.LinkedList;

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


    //recursive solution
    public static void reversePrintUsingStack(ListNode<Integer> node) {
        Deque<Integer> nodes = new LinkedList<>();
        while (node != null){
            nodes.addLast(node.data);
            node = node.next;
        }
        while (!nodes.isEmpty()){
            System.out.print(nodes.removeFirst());
            if (!nodes.isEmpty()) System.out.print("->");
        }
    }


    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(3, new ListNode<>(12, null)))));

        //reversePrint(L);
       // System.out.println(res.delete(res.length()-2,res.length()));
        reversePrintUsingStack(L);
    }
}

