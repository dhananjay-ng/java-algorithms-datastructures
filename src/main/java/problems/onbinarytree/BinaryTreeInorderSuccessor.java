package problems.onbinarytree;

public class BinaryTreeInorderSuccessor {
    /*
        Given node find Inorder successor for that node,
        Inorder successor is basically next node that will traverse in inorder traversal.
     */
    public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
        if (node.right!=null){
            node = node.right;
            while (node.left!=null) node = node.left;
            return node;
        }
        while (node.parent!=null && node.parent.right == node) {
            node = node.parent;
        }
        return node.parent;
    }
}
