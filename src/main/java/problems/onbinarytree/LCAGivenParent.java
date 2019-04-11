package problems.onbinarytree;

import java.util.HashSet;

public class LCAGivenParent {

    /**
     * Q.Given two nodes in a binary tree, design an algorithm that computes their LCA.
     * Assume that each node has a parent pointer.
     * Hint: The problem is easy if both nodes are the same distance from the root.
     */

    //make the depth of node same for both node and then start checking one by one O(log n)
    public static BinaryTree<Integer> LCAGivenParent(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {

        BinaryTree<Integer> n0 = node0;
        BinaryTree<Integer> n1 = node1;
        int n0Depth = 0;
        int n1Depth = 0;

        n0Depth = getDepth(n0, n0Depth);
        n1Depth = getDepth(n1, n1Depth);

        if(n0Depth > n1Depth) {
            for (int i = 0; i < n0Depth-n1Depth;i++)
                node0 = node0.parent;
        } else {
            for (int i = 0; i < n1Depth-n0Depth;i++)
                node1 = node1.parent;
        }
        while (node0!=null && node1!=null){
            if (node0 == node1) {
                return node0;
            }
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return null;
    }

    private static int getDepth(BinaryTree<Integer> n0, int n0height) {
        while (n0 != null) {
            n0height++;
            n0 = n0.parent;
        }
        return n0height;
    }

    //using extra space
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        HashSet<BinaryTree<Integer>> path = new HashSet<>();
        while (node0 != null) {
            path.add(node0);
            node0 = node0.parent;
        }
        while (node1 != null) {
            if (path.contains(node1)) return node1;
            node1 = node1.parent;
        }
        return null;
    }

}
