package problems.onbinarytree;

public class MaxDepth {
    public static int maxDepth(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(BinaryTreeUtils.getSampleTree(3)));

    }
    

}
