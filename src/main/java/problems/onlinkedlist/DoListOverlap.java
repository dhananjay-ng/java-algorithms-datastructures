package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class DoListOverlap {
    public static ListNode<Integer> overlappingLists(ListNode<Integer> l0,
                                                     ListNode<Integer> l1) {
        ListNode<Integer> l0CycleStart = getCycleStart(l0);
        ListNode<Integer> l1CycleStart = getCycleStart(l1);

        // code for non cyclic list overlap finding
        if (l1CycleStart == null && l0CycleStart == null) {
            return DoTerminatedListsOverlap.overlappingNoCycleLists(l0, l1);
        }

        //if one has cycle and they overlap then other inherits cycle of first.
        //so if any of them does not has cycle and other has then they don't overlap
        if (l1CycleStart == null || l0CycleStart == null) {
            return null;
        }


        ListNode<Integer> temp = l1CycleStart;
        do{
            temp = temp.next;
        }while (temp!=l0CycleStart && temp!=l1CycleStart);
        //This means they do have common cycle
        if (temp == l0CycleStart) {
            //check if they meet before cycle starts
            int l0Tol0CycleStart = distance(l0, l0CycleStart);
            int l1Tol1CycleStart = distance(l1, l1CycleStart);

            int moveBiggerListBy = Math.abs(l1Tol1CycleStart - l0Tol0CycleStart);
            if (l0Tol0CycleStart > l1Tol1CycleStart) {
                l0 = advanceListByK(moveBiggerListBy, l0);
            } else {
                l1 = advanceListByK(moveBiggerListBy, l1);
            }
            while (l0!=l1 && l0!=l0CycleStart && l1!=l1CycleStart){
                l0 = l0.next;
                l1 = l1.next;
            }
            return l0 == l1 ? l0 : l1CycleStart;
        }
        return null;
    }

    private static ListNode<Integer> advanceListByK(int moveBiggerListBy, ListNode<Integer> node) {
        while (moveBiggerListBy-- > 0) {
            node = node.next;
        }
        return node;
    }

    public static int distance(ListNode<Integer> src, ListNode<Integer> dest) {
        int dist = 0;
        while (src != dest) {
            src = src.next;
            dist++;
        }
        return dist;
    }

    private static ListNode<Integer> getCycleStart(ListNode<Integer> node) {
        ListNode<Integer> first = node, second = node;
        while (second != null && second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                first = node;
                while (first != second) {
                    first = first.next;
                    second = second.next;
                }
                return first;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode<Integer> L1;
        ListNode<Integer> L2;

        L1 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(5, null)));
        L1.next.next.next = L1;
        L2 = new ListNode<>(2, new ListNode<>(4, new ListNode<>(6, L1)));
        //L1 & L2 overlap at 3
        System.out.println(overlappingLists(L1, L2).data);
    }

}
