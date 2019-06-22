package datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;


public class Node {

    public Integer data;
    public Node next;


    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }


    public List toArray() {
        List result = new ArrayList<>();
        Node iter = this;
        while (iter != null) {
            result.add(iter.data);
            iter = iter.next;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Set<Node> visited = new HashSet<Node>();
        Node node = this;
        boolean first = true;

        while (node != null) {
            if (first) {
                first = false;
            } else {
                result.append(" -> ");
            }
            if (visited.contains(node)) {
                if (node.next != node) {
                    result.append(node.data == null ? "null" : node.data.toString())
                            .append(" -> ... -> ");
                }
                result.append(node.data == null ? "null" : node.data.toString())
                        .append(" -> ...");
                break;
            } else {
                result.append(node.data == null ? "null" : node.data.toString());
                visited.add(node);
                node = node.next;
            }
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node that = (Node) o;

        return equalsIterativeImpl(this, that);
    }

    public static boolean equalsIterativeImpl(Node a, Node b) {
        Set<Node> visitedA = new HashSet<Node>();
        Set<Node> visitedB = new HashSet<Node>();

        while (a != null && b != null) {
            if (visitedA.contains(a)) {
                return a.data.equals(b.data) && visitedB.contains(b);
            }
            if (!a.data.equals(b.data)) {
                return false;
            }
            visitedA.add(a);
            visitedB.add(b);
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    public int size() {
        int result = 0;
        Set<Node> visited = new HashSet<Node>();
        Node node = this;

        while (node != null && !visited.contains(node)) {
            result++;
            visited.add(node);
            node = node.next;
        }
        return result;
    }

    public Node search(Node startNode, Integer key) {
        while (startNode != null && startNode.data != key) {
            startNode = startNode.next;
        }
        return startNode;
    }

    public void insertAfter(Node source, Node toBeInsertedNode) {
        toBeInsertedNode.next = source.next;
        source.next = toBeInsertedNode;
    }

    public  void deleteNode(Node toBeDeleted){
        toBeDeleted.next = toBeDeleted.next.next;
    }

}

