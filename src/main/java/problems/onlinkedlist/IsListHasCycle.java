package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import java.util.HashMap;
import java.util.HashSet;

public class IsListHasCycle {

    // Observation: 3rd solution
    // When first and second meet with fast and slow pointer
    // the if we traverse from head and from that meeting point
    // then this meet at the start.
    public static ListNode<Integer> hasCycleShortSolution(ListNode<Integer> head) {
        ListNode<Integer> first = head, second = head;

        while (second != null && second.next != null && second.next.next!=null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                first = head;
                while (first!=second){
                    first = first.next;
                    second=second.next;
                }
                return first;
            }
        }
        return null;
    }

    //constant space, linear time O(n)
    public static ListNode<Integer> hasCycleWithoutExtraSpace(ListNode<Integer> head) {
        ListNode<Integer> first = head, second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if (first == second) {
                int cycleLength = 1;
                first = first.next;
                while (first != second) {
                    cycleLength++;
                    first = first.next;
                }
                ListNode<Integer> cycleLenghtIterator = head;
                while (cycleLength-- > 0) {
                    cycleLenghtIterator = cycleLenghtIterator.next;
                }

                //when @cycleLenghtIterator is ahead of @head by cycle length that means,
                //when @cycleLenghtIterator complete traversing cycle and reach start node
                //the head will also reach start node.
                while (head != cycleLenghtIterator) {
                    head = head.next;
                    cycleLenghtIterator = cycleLenghtIterator.next;
                }
                return head;
            }
        }
        return null;
    }

         //linear time O(n) space O(cyclelength) for hashMap
        public static ListNode<Integer> hasCycle (ListNode < Integer > head) {
            if (head == null) return null;
            ListNode<Integer> first = head;
            ListNode<Integer> second = null;
            if (head.next != null) {
                second = head.next.next;
            } else {
                return null;
            }
            HashSet<ListNode<Integer>> visited = new HashSet<>();

            while (second != null && second.next != null && second != first) {
                first = first.next;
                second = second.next.next;
            }
            if (second != null && first == second) {
                while (!visited.contains(first)) {
                    visited.add(first);
                    first = first.next;
                }
                while (!visited.contains(head)) {
                    head = head.next;
                }
                return head;
            }
            return null;
        }

        public static void main (String[]args){
            ListNode<Integer> L;
            L = new ListNode<>(11, new ListNode<>(3,
                    new ListNode<>(5, new ListNode<>(7, new ListNode<>(2, null)))));

            //cycle from endnode 2 to second node 3
            L.next.next.next.next = L.next;

            L = hasCycle(L);
            L = hasCycleWithoutExtraSpace(L);

            if (L != null) {
                System.out.println(L.data); //should print 3

                /**********Print Cycle **************/
                ListNode<Integer> start = L;
                StringBuilder res = new StringBuilder();
                res.append("=>=>").append(start.data);
                L = L.next;
                while (L != start) {
                    res.append("->->").append(L.data);
                    L = L.next;
                }
                res.append("=>=>");
                System.out.println(res.toString());
            }
        }

    }
