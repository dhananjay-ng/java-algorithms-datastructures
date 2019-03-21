package problems.onqueue;

import problems.onbinarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelTraversal {
    public static List<List<Integer>>
    binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> l1 = new LinkedList<>();
        Deque<BinaryTreeNode<Integer>> l2 = new LinkedList<>();
        List<List<Integer>> dfs = new ArrayList<>();
        if (tree != null) l1.addLast(tree);
        while (!l1.isEmpty() || !l2.isEmpty()) {
            List<Integer> level = new ArrayList();
            if (!l1.isEmpty()) {
                processLevel(l1, l2, level);
            } else {
                processLevel(l2, l1, level);
            }
            if(level.size()>0){
                dfs.add(level);
            }
        }
        return dfs;
    }

    private static void processLevel(Deque<BinaryTreeNode<Integer>> l1, Deque<BinaryTreeNode<Integer>> l2, List<Integer> level) {
        while (!l1.isEmpty()) {
            if (l1.peek() != null) {
                level.add(l1.peek().data);
                BinaryTreeNode<Integer> node = l1.removeFirst();
                l2.addLast(node.left);
                l2.addLast(node.right);
            } else {
                l1.removeFirst();
            }

        }
    }
}
