package websites.he.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BST<Key extends Comparable<Key>> {
    private Node root;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();                 // Reading input from STDINbs
        while (t-- > 0) {
            int n = s.nextInt();                 // Reading input from STDINbs
            BST<Integer> bst = new BST<>();
            for (int i = 0; i < n; i++) {
                bst.add(s.nextInt());
            }
            System.out.println(bst.findLeftExteriorNodes());

        }

    }

    public int findLeftExteriorNodes() {
        Deque<Node> currentLevel = new LinkedList<>();
        Deque<Node> nextLevel = new LinkedList<>();
        currentLevel.addFirst(root);
        int kills = 0;
        boolean isFirst = true;
        while (!currentLevel.isEmpty()){
            Node ele = currentLevel.removeFirst();
            if (ele.left!=null) nextLevel.addFirst(ele.left);
            if (ele.right!=null) nextLevel.addFirst(ele.right);
            if (isFirst) kills++;

            isFirst = false;

            if (currentLevel.isEmpty() &&  !nextLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                isFirst = true;
            }
        }
        return kills;
    }


    public Key maxOnPathBetweenTwoNodes(Key x, Key y) {
        Node iter = root;
        while (iter!=null) {
            if (x.compareTo(iter.key) < 0 && y.compareTo(iter.key) < 0){
                iter = iter.left;
            } else if (x.compareTo(iter.key) > 0 && y.compareTo(iter.key) > 0) {
                iter = iter.right;
            } else {
                break;
            }
        }
        Node pathRoot = iter;
        if (pathRoot == null){
            pathRoot = root;
        }
        Key max = pathRoot.key;
        iter = pathRoot;
        while (iter!=null) {
            if (x.compareTo(iter.key) > 0){
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                iter = iter.right;
            } else if (x.compareTo(iter.key) < 0){
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                iter= iter.left;
            } else {
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                break;
            }
        }
        iter = pathRoot;
        while (iter!=null) {
            if (y.compareTo(iter.key) > 0){
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                iter = iter.right;
            } else if (y.compareTo(iter.key) < 0){
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                iter= iter.left;
            } else {
                max = max.compareTo(iter.key) > 0 ? max:iter.key;
                break;
            }
        }
        return max;

    }

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

