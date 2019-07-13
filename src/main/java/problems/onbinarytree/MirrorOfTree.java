package problems.onbinarytree;

public class MirrorOfTree {
    /**
     * Explanation:
     * Testcase1: The tree is
     *         1         (mirror)     1
     *      /      \         =>        /     \
     *    3       2                  2         3
     * The inorder of mirror is 2 1 3
     * Testcase2: The tree is
     *                            10                                      10
     *                         /        \           (mirror)         /        \
     *                      20         30            =>        30        20
     *                   /       \                                              /    \
     *                40       60                                        60    40
     * The inroder traversal of mirror is 30 10 60 20 40.
     */
    void mirror(TreeNode TreeNode)
    {
        if (TreeNode.left == null && TreeNode.right == null) return;
        if(TreeNode != null) {
            TreeNode temp = TreeNode.left;
            TreeNode.left = TreeNode.right;
            TreeNode.right =  temp;
            if(TreeNode.left!=null)
                mirror(TreeNode.left);
            if(TreeNode.right!=null)
                mirror(TreeNode.right);
        }
    }
}
