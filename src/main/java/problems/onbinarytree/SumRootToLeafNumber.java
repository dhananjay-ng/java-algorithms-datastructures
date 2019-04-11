package problems.onbinarytree;

public class SumRootToLeafNumber {
    /**
     * 129. Sum Root to Leaf Numbers
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * <p>
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * <p>
     * Find the total sum of all root-to-leaf numbers.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     *   1
     *  / \
     * 2   3
     * Output: 25
     * Explanation:
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * Therefore, sum = 12 + 13 = 25.
     * Example 2:
     * <p>
     * Input: [4,9,0,5,1]
     *     4
     *    / \
     *   9   0
     *  / \
     * 5   1
     * Output: 1026
     * Explanation:
     * The root-to-leaf path 4->9->5 represents the number 495.
     * The root-to-leaf path 4->9->1 represents the number 491.
     * The root-to-leaf path 4->0 represents the number 40.
     * Therefore, sum = 495 + 491 + 40 = 1026.
     */
    public int sumNumbers(TreeNode root) {
        return getSumForAllRootToLeaf(root, 0, 0);
    }

    public int getSumForAllRootToLeaf(TreeNode root, int total, int curSum) {
        if (root == null) return total;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += curSum;
            return total;
        }
        total = getSumForAllRootToLeaf(root.left, total, curSum);
        return getSumForAllRootToLeaf(root.right, total, curSum);
    }

}
