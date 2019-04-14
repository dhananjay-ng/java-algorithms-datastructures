package problems.onbinarytree;

public class FindKthNodeInInorderTraversal {
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;
        public int size;

        public BinaryTreeNode(T data, BinaryTreeNode<T> left,
                              BinaryTreeNode<T> right, int size) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.size = size;
        }
    }

    public static BinaryTreeNode<Integer>
    findKthNodeBinaryTree(BinaryTreeNode<Integer> tree, int k) {
        int curNodePos = (tree.left != null ? (tree.left.size + 1) : 1);
        if (k == curNodePos) return tree;
        else if (k < curNodePos) {
            return findKthNodeBinaryTree(tree.left, k);
        } else {
            return findKthNodeBinaryTree(tree.right, k - curNodePos);
        }
    }

}
