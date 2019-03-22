package problems.onqueue;

import problems.onbinarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelTraversal {
    public static List<List<Integer>>
    binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> currentLevel = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (tree != null) currentLevel.addLast(tree);
        while (!currentLevel.isEmpty()) {
            Deque<BinaryTreeNode<Integer>> nextLevel = new LinkedList<>();
            List<Integer> level = new ArrayList();
            while (!currentLevel.isEmpty()) {
                BinaryTreeNode<Integer> node = currentLevel.removeFirst();
                if (node!= null) {
                    level.add(node.data);
                    nextLevel.addLast(node.left);
                    nextLevel.addLast(node.right);
                }
            }
            currentLevel = nextLevel;
            if(level.size()>0){
                res.add(level);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //to-do: write test client
    }

}
