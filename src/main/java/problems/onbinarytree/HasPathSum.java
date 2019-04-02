package problems.onbinarytree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // return root!=null &&  hasPathSumm(root,sum);
        if(root == null) return false;
        if(root.left == null && root.right ==null){
            if(root.val == sum){
                return true;
            }
            return false;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);

    }
}
