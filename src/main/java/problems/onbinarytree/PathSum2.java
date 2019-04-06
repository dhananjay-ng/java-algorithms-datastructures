package problems.onbinarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    /**
     * 113. Path Sum II
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given the below binary tree and sum = 22,
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \    / \
     * 7    2  5   1
     * Return:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findPathSumPaths(root, res, new ArrayList<>(), 0, sum);
        return res;
    }

    public void findPathSumPaths(TreeNode root, List<List<Integer>> res,
                                 List<Integer> curPath, int curSum, int sum) {
        if(root == null) return;
        curPath.add(root.val);
        curSum += root.val;
        if(root.left == null && root.right == null) {
            if(curSum == sum) {
                res.add(new ArrayList<>(curPath));
            }
        }
        findPathSumPaths(root.left, res, curPath, curSum, sum);
        findPathSumPaths(root.right, res, curPath, curSum, sum);
        curPath.remove(curPath.size()-1);
    }
}
