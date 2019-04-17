package problems.onbinarytree;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeFromPreorderWithMarkers {
    /**
     * Many different binary trees have the same preorder traversal sequence.
     * In this problem, the preorder traversal computation is modified to mark where a
     * left or right child is empty. For example, the binary tree in Figure 10.5 on the facing
     * page yields the following preorder traversal sequence:
     * (H, B, F, null,null, E,A, null,null,null, C, null, D, null, G, , null,null, null)
     * Design an algorithm for reconstructing a binary tree from a preorder traversal visit
     * sequence that uses null to mark empty children.
     */
    private static int preIdx = 0;

    public static BinaryTreeNode<Integer>
    reconstructPreorder(List<Integer> preorder) {
        if (preorder.size() == 0) return null;
        BinaryTreeNode<Integer> root = null;
        preIdx = 0;
        return helper(root, preorder);
    }

    private static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root, List<Integer> preorder) {
        if (preIdx >= preorder.size() || preorder.get(preIdx) == null) {
            return null;
        }
        root = new BinaryTreeNode<>();
        root.data = preorder.get(preIdx);
        preIdx++;
        root.left = helper(root, preorder);
        preIdx++;
        root.right = helper(root, preorder);
        return root;
    }


}
