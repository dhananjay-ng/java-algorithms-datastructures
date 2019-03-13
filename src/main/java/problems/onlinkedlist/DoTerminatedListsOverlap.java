package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class DoTerminatedListsOverlap {


    //This solution first calculates length of both lists, moves the bigger list head by diff between both
    //and then when traversing both list if they overlap they will reach that point at the same time.
    public static ListNode<Integer>
    overlappingNoCycleListsSolutionByLength(ListNode<Integer> l0, ListNode<Integer> l1) {
        if (l0 == null || l1 == null) return null;
        int l0links = 0; //l0links is nothing but length of lo
        int l1links = 0;
        ListNode<Integer> l0Head = l0, l1Head = l1;
        while (l0 != null) {
            l0links++;
            l0 = l0.next;
        }
        while (l1 != null) {
            l1links++;
            l1 = l1.next;
        }
        if (l1links > l0links) {  //if length of l1 is bigger advance it by diff positions
            int diff = l1links - l0links;
            while (diff-- > 0) {
                l1Head = l1Head.next;
            }
        }
        if (l0links > l1links) {   //if length of l0 is bigger advance it by diff positions
            int diff = l0links - l1links;
            while (diff-- > 0) {
                l0Head = l0Head.next;
            }
        }

        while (l1Head != null && l0Head != null) {
            if (l1Head == l0Head) return l0Head;  //if common node is found this is overlapping point.
            l0Head = l0Head.next;
            l1Head = l1Head.next;
        }
        return null;
    }

    //Linear time uses O(l0.size() extra space for visited node(HashSet), space can be reduced by
    //visiting smaller list of them, but no good if both are of equal size.
    public static ListNode<Integer>
    overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
        HashSet<ListNode<Integer>> visited = new HashSet<>();
        if (l0 == null || l1 == null) return null;
        while (l0 != null) {
            visited.add(l0);
            l0 = l0.next;
        }
        while (l1 != null) {
            if (visited.contains(l1)) return l1;
            l1 = l1.next;
        }
        return null;
    }


    // Quadratic brute force
    public static ListNode<Integer>
    overlappingNoCycleListsQuadratic(ListNode<Integer> l0, ListNode<Integer> l1) {
        ListNode<Integer> l1Head = l1;
        while (l0 != null) {
            while (l1 != null) {
                if (l1 == l0) {
                    return l0;
                }
                l1 = l1.next;
            }
            l1 = l1Head;
            l0 = l0.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode<Integer> L1;
        ListNode<Integer> L2;

        L1 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(5, null)));
        L2 = new ListNode<>(2, new ListNode<>(4, new ListNode<>(6, L1.next)));
        //L1 & L2 overlap at 3
        System.out.println(overlappingNoCycleListsSolutionByLength(L1, L2).data);

    }
}
