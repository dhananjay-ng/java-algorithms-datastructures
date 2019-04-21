package problems.onbinarytree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TreeRightSiblingOnSamelevel {
    /***
     * For this problem, assume that each binary tree node has a extra field, call it level-next,
     * that holds a binary tree node (this field is distinct from the fields for the left and right
     * children). The level-next field will be used to compute a map from nodes to their
     * right siblings.
     * Write a program that takes a perfect binary tree, and sets each node's level-next field
     * to the node on its right, if one exists.
     */
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;
        public BinaryTreeNode<T> next = null; // Populates this field.

        public BinaryTreeNode(T data) { this.data = data; }
    }
    public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
        BinaryTreeNode<Integer> leftstart = tree;
        while (leftstart!=null && leftstart.left!=null) {
            nextLinkBuilder(leftstart);
            leftstart = leftstart.left;
        }
    }

    private static void nextLinkBuilder(BinaryTreeNode<Integer> leftstart) {
        BinaryTreeNode<Integer> iter = leftstart;
        while (iter != null) {
            iter.left.next = iter.right;
            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }

    public static void constructRightSibling1(BinaryTreeNode<Integer> tree) {
        if (tree == null) return;
        Deque<BinaryTreeNode<Integer>> currentlevel = new LinkedList<>();
        Deque<BinaryTreeNode<Integer>> nextlevel = null;
        currentlevel.add(tree);
        while (!currentlevel.isEmpty()) {
            nextlevel = new LinkedList<>();
            while (!currentlevel.isEmpty()) {
                BinaryTreeNode<Integer> node = currentlevel.removeLast();
                if (node.left !=null)
                    nextlevel.addFirst(node.left);
                if (node.right != null)
                    nextlevel.addFirst(node.right);
            }

            Iterator<BinaryTreeNode<Integer>> iter =  nextlevel.descendingIterator();
            BinaryTreeNode<Integer> prev = null;
            while (iter.hasNext()) {
                BinaryTreeNode<Integer> curr = iter.next();
                if (prev!=null){
                    prev.next = curr;
                }
                prev = curr;
            }

            currentlevel = nextlevel;
        }
    }
}
