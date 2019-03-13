package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public class IsListHasCycle {
    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        if (head == null) return null;
        ListNode<Integer> first = head;
        ListNode<Integer> second = null;
        if (head.next!=null){
            second=head.next.next;
        } else {
            return null;
        }
        HashMap<ListNode<Integer>, ListNode<Integer>> visited =  new HashMap();

        while (second != null && second.next!=null && second != first) {
            first = first.next;
            second = second.next.next;
        }
        if (second!=null && first == second){
            while (!visited.containsKey(first)){
                visited.put(first,first);
                first = first.next;
            }
            while (!visited.containsKey(head)){
                head=head.next;
            }
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

        //cycle from endnode 2 to second node 3
        L.next.next.next.next= L.next;

        L = hasCycle(L);

        if (L!=null) {
            System.out.println(L.data); //should print 3

            /**********Print Cycle **************/
            ListNode<Integer> start = L;
            StringBuilder res = new StringBuilder();
            res.append("=>=>").append(start.data);
            L=L.next;
            while (L!=start){
                res.append("->->").append(L.data);
                L=L.next;
            }
            res.append("=>=>");
            System.out.println(res.toString());
        }
    }

}
