package problems.onsorting;

class Node {
    int data;
    Node next;

    Node(int key) {
        this.data = key;
        next = null;
    }
}


public class MergeSortLinkedList {
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node firstHalf = mergeSort(head);
        Node secondHalf = mergeSort(nextOfMiddle);

        return mergeOp(firstHalf, secondHalf);
    }

    static Node getMiddle(Node head) {
        if (head == null) return head;
        Node fastPtr = head.next;
        Node slowPtr = head;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if (fastPtr != null) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
        }
        return slowPtr;
    }

    static Node mergeOp(Node a, Node b) {
        Node result;
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            result = a;
            result.next = mergeOp(a.next, b);
        } else {
            result = b;
            result.next = mergeOp(a, b.next);
        }

        return result;
    }

}
