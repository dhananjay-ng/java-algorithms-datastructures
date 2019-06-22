package problems.onhashtable;

import datastructures.linkedlist.Node;

import java.util.TreeSet;

public class IntersectionOfTwoLists {
    /***
     * Given two linked lists, the task is to complete the function findIntersection(), that returns the intersection of two linked lists. Each of the two linked list contains distinct node values.
     *
     * Input:
     * The function takes 2 arguments, reference pointer to the head of the first linked list (head1) and reference pointer to the head of the second linked list (head2). There are multiple test cases and for each test case this function will be called separately.
     *
     * Output:
     * The function should return reference pointer to the head of the new list that is formed by the intersection of the two the lists.
     * Note: The new list formed should be in non-decreasing order. Also if there is no intersecting nodes among two linked lists, then print empty line.
     *
     * User Task:
     * Since this is a functional problem you don't have to worry about input, you just have to complete the function findIntersection().
     *
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 103
     *
     * Example:
     * Input:
     * 1
     * 6
     * 9 6 4 2 3 8
     * 4
     * 1 2 8 6
     * Output:
     * 2 6 8
     */
    static Node findIntersection(Node head1, Node head2)
    {
        TreeSet<Integer> nodes = new TreeSet<>();
        TreeSet<Integer> common = new TreeSet<>();
        while (head1 != null) {
            nodes.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            if(nodes.contains(head2.data)) {
                common.add(head2.data);
            }
            head2 = head2.next;
        }

        head1 = new Node(0);
        Node iter = head1;
        for (int node : common) {
            iter.next = new Node(node);
            iter = iter.next;
        }
        return head1.next;
    }
}
