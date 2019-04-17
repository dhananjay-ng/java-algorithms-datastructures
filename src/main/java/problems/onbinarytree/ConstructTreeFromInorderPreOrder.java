package problems.onbinarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderPreOrder {
    /***
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder.length <= 0 || preorder.length <= 0)
            return null;

        Map<Integer, Integer> inordermap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inordermap.put(inorder[i], i);
        }

        return helper(inorder, preorder, inordermap, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] preorder, Map<Integer, Integer> inordermap, int prestart, int instart, int inend) {

        if (prestart > preorder.length - 1 || instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int partition = inordermap.get(preorder[prestart]);
        prestart++;

        root.left = helper(inorder, preorder, inordermap, prestart, instart, partition - 1);
        root.right = helper(inorder, preorder, inordermap, prestart + partition - instart, partition + 1, inend);

        return root;
    }
}
