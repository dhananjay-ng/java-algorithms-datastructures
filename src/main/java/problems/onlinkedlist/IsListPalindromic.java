package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;
public class IsListPalindromic {

    public static boolean isLinkedListAPalindrome(ListNode<Integer> node) {

        if (node == null) return true;
        ListNode<Integer> dummyHead = new ListNode<>(0, node);
        ListNode<Integer> slow = node;
        ListNode<Integer> fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverseFromNode(slow);
        //or

        ListNode<Integer> secondHalf =  ReverseLinkedListIterative.reverseLinkedList(slow);
        ListNode<Integer> firstHalf = dummyHead.next;
        while (secondHalf != null && firstHalf != null) {
            if (secondHalf.data.intValue() != firstHalf.data.intValue()) {
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    public static void reverseFromNode(ListNode<Integer> node) {
        if (node == null || node.next == null) return;
        ListNode<Integer> listIter = node.next;
        while (listIter != null && listIter.next != null) {
            ListNode<Integer> detachNode = listIter.next;
            listIter.next = detachNode.next;
            detachNode.next = node.next;
            node.next = detachNode;
        }
        return;
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
        L = new ListNode<>(2, new ListNode<>(5,
                new ListNode<>(5,
                        new ListNode<>(2,null))));

        System.out.println(isLinkedListAPalindrome(L));

    }
}
