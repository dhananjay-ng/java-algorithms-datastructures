package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class DoListsOverlap {


    //Linear time uses O(l0.size() extra space for visited node(HashSet), space can be reduced by
    //visiting smaller list of them, but no good if both are of equal size.
    public static ListNode<Integer>
    overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
        HashSet<ListNode<Integer>> visited = new HashSet<>();
        if (l0==null||l1==null) return null;
        while (l0!=null){
            visited.add(l0);
            l0=l0.next;
        }
        while (l1!=null){
            if (visited.contains(l1)) return l1;
            l1=l1.next;
        }
        return null;
    }


    // Quadratic brute force
    public static ListNode<Integer>
    overlappingNoCycleListsQuadratic(ListNode<Integer> l0, ListNode<Integer> l1) {
        ListNode<Integer> l1Head = l1;
        while (l0!=null){
            while (l1!=null){
                if (l1==l0){
                    return l0;
                }
                l1=l1.next;
            }
            l1=l1Head;
            l0=l0.next;
        }    return null;
    }
    public static void main(String[] args) {
        ListNode<Integer> L1;
        ListNode<Integer> L2;

        L1 = new ListNode<>(1,new ListNode<>(3,new ListNode<>(5,null)));
        L2 =new ListNode<>(2,new ListNode<>(4,new ListNode<>(6,L1.next)));
        //L1 & L2 overlap at 3
        System.out.println(overlappingNoCycleListsQuadratic(L1,L2).data);

    }
}
