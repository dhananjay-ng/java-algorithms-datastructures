package problems.onbinarytree.onbst;

import java.io.IOException;
import java.util.Scanner;

public class HeightOfBst {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDINbs
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < n; i++) {
            bst.add(s.nextInt());
        }
        //int q = s.nextInt();
        //bst.preorder(bst.get(q));
        System.out.println(bst.height());
    }
}


class BST<Key extends Comparable<Key>> {
    private Node root;

    public Node add(Key key) {
        this.root = add(key, this.root);
        return this.root;
    }

    private Node add(Key key, Node root) {
        if (root == null) {
            root = new Node(key);
        } else if (key.compareTo(root.key) <= 0) {
            root.left = add(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            root.right = add(key, root.right);
        }
        return root;
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preorder(node.left);
            preorder(node.right);

        }
    }

    public Node get(Key key) {
        return get(key, root);
    }

    public Node get(Key key, Node root) {
        if (root == null) return null;
        else if (root.key.compareTo(key) == 0) {
            return root;
        } else if (key.compareTo(root.key) < 0) {
            return get(key, root.left);
        } else {
            return get(key, root.right);
        }
    }

    //https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-watching-fight/
    public int height() {
        return height(root);
    }

    public int height(Node node) {
        if (node == null) return 0;
        else if (node.left == null && node.right == null) return 1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    class Node {
        Key key;
        Node left;
        Node right;

        public Node(Key key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
}