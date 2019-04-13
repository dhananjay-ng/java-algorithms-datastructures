package problems.onbinarytree;

public class SumofRootToLeafBinaryNumbers {
    //1022. Sum of Root To Leaf Binary Numbers
    /**
     * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
     *
     * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
     *
     * Return the sum of these numbers.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: [1,0,1,0,1,0,1]
     * Output: 22
     * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     *
     *
     * Note:
     *
     * The number of nodes in the tree is between 1 and 1000.
     * node.val is 0 or 1.
     * The answer will not exceed 2^31 - 1.
     */

    public int sumRootToLeaf(TreeNode root) {
        return getSumForAllRootToLeaf(root, 0, 0);

    }
    public int getSumForAllRootToLeaf(TreeNode root, int total, int curSum) {
        if (root == null) return total;
        if (root.left == null && root.right == null) {
            //2^0 is 1 so no need to multyply by 2.
            curSum = curSum  + root.val;

            total += curSum;
            return total;
        }
        curSum = curSum*2  + root.val *2;
        total = getSumForAllRootToLeaf(root.left, total, curSum);
        return getSumForAllRootToLeaf(root.right, total, curSum);
    }
}
