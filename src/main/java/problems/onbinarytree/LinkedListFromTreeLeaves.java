package problems.onbinarytree;

import java.util.ArrayList;
import java.util.List;

public class LinkedListFromTreeLeaves {
    public static List<BinaryTreeNode<Integer>>
    createListOfLeaves(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> res = new ArrayList<>();
        helper(tree, res);
        return res;
    }

    private static void helper(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> res) {
        if (tree!=null ){
            if ( tree.left==null && tree.right==null){
                res.add(tree);
            }
            helper(tree.left, res);
            helper(tree.right, res);
        }

    }

}
