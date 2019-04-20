package problems.onbinarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeExterior {
    /***
     * The exterior of a binary tree is the following sequence of nodes: the nodes from the
     * root to the leftmost leaf, followed by the leaves in left-to-right order, followed by the
     * nodes from the rightmost leaf to the root. (By leftmost (rightmost) leaf, we mean the
     * leaf that appears first (last) in an inorder traversal.)
     * Write a program that computes the exterior of a binary tree.
     */

    public static List<BinaryTreeNode<Integer>>
    exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> res = new ArrayList<>();
        if (tree!=null) {
            res.add(tree);
            if (tree.left!=null) addLeftSide(tree.left, res);
            if (tree.right!=null) addRightSide(tree.right,res);
        }
        return res;
    }
    private static void addLeftSide(BinaryTreeNode<Integer> leftRoot, List<BinaryTreeNode<Integer>> res) {
        BinaryTreeNode<Integer> lroot = leftRoot;
        while (leftRoot != null && !(leftRoot.left == null && leftRoot.right == null)) {
            res.add(leftRoot);
            if (leftRoot.left != null)
                leftRoot = leftRoot.left;
            else leftRoot = leftRoot.right;
        }
        addLeafNodes(lroot, res);
    }

    private static void addLeafNodes(BinaryTreeNode<Integer> root, List<BinaryTreeNode<Integer>> res) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(root);
            }
            addLeafNodes(root.left, res);
            addLeafNodes(root.right, res);
        }
    }

    private static void addRightSide(BinaryTreeNode<Integer> rightRoot, List<BinaryTreeNode<Integer>> res) {
        addLeafNodes(rightRoot, res);
        addRightPath(rightRoot, res);
    }
    private static void addRightPath(BinaryTreeNode<Integer> rightRoot, List<BinaryTreeNode<Integer>> res) {
        if (rightRoot!=null ){
            if (rightRoot.right != null)
                addRightPath(rightRoot.right, res);
            else addRightPath(rightRoot.left, res);

            if(!(rightRoot.right == null && rightRoot.left == null)) {
                res.add(rightRoot);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.getSampleTree(2);
        exteriorBinaryTree(root).stream().forEach(
                integerBinaryTreeNode -> {
                    System.out.print(integerBinaryTreeNode.data + " ");
                }
        );
    }
}
