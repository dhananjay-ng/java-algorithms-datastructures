package problems.onlinkedlist;

import datastructures.linkedlist.ListNode;

public class AddTwoLists {

    /*** Time O(n + m) space O(max(m,n)).**/
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1,
                                                  ListNode<Integer> L2) {
        ListNode<Integer> dummyHead = new ListNode<>(0,null);
        ListNode<Integer> placeIter = dummyHead;
        int carry=0,sum=0;
        while (L1!= null || L2!=null){
            sum = carry;
            if (L1 != null){
                sum += L1.data;
                L1 = L1.next;
            }
            if (L2 != null){
                sum += L2.data;
                L2 = L2.next;
            }
            placeIter.next = new ListNode<>(sum%10,null);
            placeIter = placeIter.next;
            carry = sum/10;
        }
        if (carry > 0){
            placeIter.next = new ListNode<>(carry,null);
        }
        return dummyHead.next;
    }


    /**** Intial solution*/
    public static ListNode<Integer> addTwoNumbersIntial(ListNode<Integer> L1,
                                                  ListNode<Integer> L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;
        ListNode<Integer> dummyHead = new ListNode<>(0,L1);
        int res=0, carry=0,sum=0;
        while (L1.next != null && L2.next!=null){
            res = L1.data + L2.data + carry;
            carry = 0; sum = res;
            if (res > 9){
                sum %= 10;
                carry = res/10;
            }
            L1.data = sum;
            L1 = L1.next;
            L2 = L2.next;
        }
        if (L1.next == null && L2.next == null) {
            res = L1.data + L2.data + carry;
            carry = 0; sum = res;
            if (res > 9){
                sum %= 10;
                carry = res/10;
            }
            L1.data = sum;
            if (carry > 0) L1.next = new ListNode<>(carry,null);
            return dummyHead.next;
        }
        else if (L1.next == null) {
            res = L1.data + L2.data + carry;
            carry = 0; sum = res;
            if (res > 9){
                sum %= 10;
                carry = res/10;
            }
            L1.data = sum;
            if (carry > 0) {
                L1.next = L2.next;
                addCarryToList(L1.next, carry);
            } else {
                L1.next = L2.next;
            }
        } else {
            res = L1.data + L2.data + carry;
            carry = 0; sum = res;
            if (res > 9){
                sum %= 10;
                carry = res/10;
            }
            L1.data = sum;
            if (carry > 0){
                addCarryToList(L1.next,carry);
            }
        }

        return dummyHead.next;
    }

    private static void addCarryToList(ListNode<Integer> node, int carry) {
        if (node == null) return;
        int res=0,sum=0;
        while (node.next!=null) {
            res = node.data + carry;
            carry = 0;
            sum = res;
            if (res > 9) {
                sum = sum % 10;
                carry = res / 10;
            }
            node.data = sum;
            node = node.next;
            if (carry == 0) return;
        }
        res = node.data + carry;
        carry = 0;
        sum = res;
        if (sum > 9){
            sum = sum %10;
            carry = res/10;
        }
        node.data = sum;
        if (carry > 0){
            node.next = new ListNode<>(carry,null);
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> L1;
        ListNode<Integer> L2;
        L1 = new ListNode<>(6,new ListNode<>(2,new ListNode<>(4,null)));
        L2 =new ListNode<>(3,new ListNode<>(8,new ListNode<>(6,new ListNode<>(9,
                new ListNode<>(4,new ListNode<>(5,null))))));
        System.out.println(addTwoNumbers(L1,L2));

    }
}
