package problems.patterns.ontwopointerstrategy;

import datastructures.linkedlist.Node;

public class DeleteMiddleOfList {
    /***
     * Given a singly linked list, delete middle  of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
     *
     * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
     *
     * If the input linked list is NULL, then it shoudl remain NULL.
     *
     * If the input linked list has 1 node, then this node should be deleted and new head should be returned.
     *
     * Input:
     * You have to complete the method which takes one argument: the head of the linked list. You should not read any input from stdin/console.
     * The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
     * There are multiple test cases. For each test case, this method will be called individually.
     *
     * Output:
     * Your function should return head  of the modified linked list.  If linked list is empty then it should return NULL.
     *
     * Constraints:
     * 1 <=T<= 50
     * 1 <=N<= 1000
     * 1 <=value<= 1000
     *
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 3 4 5
     * 6
     * 2 4 6 7 5 1
     *
     * Output:
     * 1 2 4 5
     * 2 4 6 5 1
     */
    Node Delete(Node head) {

        // Base cases
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers to reach
        // middle of linked list
        Node slow_ptr = head;
        Node fast_ptr = head;

        // Find the middle and previous of middle.
        Node prev = null;

        // To store previous of slow_ptr
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        //Delete the middle node
        prev.next = slow_ptr.next;

        return head;
        // This is method only submission.
        // You only need to complete the method.
    }
}
