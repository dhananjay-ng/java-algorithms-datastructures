package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
import edu.princeton.cs.algs4.In;

public class IsListPalindromic {

    //To-do: imporove
    public static boolean isLinkedListAPalindrome(ListNode<Integer> node) {

        ListNode<Integer> dummyHead = new ListNode<>(0,node);
        int listlen = 0;
        while (node!=null){
            node = node.next;
            listlen++;
        }
        ListNode<Integer> subListStart = dummyHead;
        for (int i = 0; i < (listlen/2); i++)
            subListStart = subListStart.next;

        //reverse second part
        // this will node will get shifted from start position to finish
        // and also act as itrator for list
        ListNode<Integer> listIterator = subListStart.next;
        for (int k = listlen/2; k < listlen-1; k++) {
            //this code puts next node of iterator at the start of sublist
            //making sublist reverse.
            ListNode<Integer> detachedNode = listIterator.next;
            listIterator.next = detachedNode.next;
            detachedNode.next = subListStart.next;
            subListStart.next = detachedNode;
        }
        subListStart = subListStart.next;
        node = dummyHead.next;
        while (subListStart!=null && node!=null ){
            if (subListStart.data.intValue()!=node.data.intValue()){
                return false;
            }
            subListStart=subListStart.next;
            node=node.next;
        }
        return true;
    }


    //less than O(n2)
    public static boolean isLinkedListAPalindromeBruteForce(ListNode<Integer> node) {
        ListNode<Integer> dummyHead = new ListNode<>(0,node);
        int listlen = 0;
        while (node!=null){
            node = node.next;
            listlen++;
        }
        ListNode<Integer> lk = dummyHead.next;
        ListNode<Integer> rk = dummyHead.next;
        for (int i=0;i<listlen/2;i++){
            int rks = listlen-2*i;
            while (rks-- > 1) {
                rk = rk.next;
            }
            if (!lk.data.equals(rk.data)){
                return false;
            }

            lk = lk.next;
            rk = lk;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode<Integer> L;
        L = new ListNode<>(11, new ListNode<>(3,
                new ListNode<>(5, new ListNode<>(3, new ListNode<>(11, null)))));

        System.out.println(isLinkedListAPalindrome(L));

    }
}
