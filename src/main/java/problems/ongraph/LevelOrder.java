package problems.ongraph;

import problems.onbinarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> level = new LinkedList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        level.add(A);
        while (!level.isEmpty() || !nextLevel.isEmpty()) {
            while (!level.isEmpty()) {
                TreeNode s = level.removeFirst();
                res.add(s.val);
                if (s.left != null) {
                    nextLevel.add(s.left);
                }
                if (s.right != null) {
                    nextLevel.add(s.right);
                }
            }
            if (res.size() != 0) {
                result.add(res);
            }
            if (!nextLevel.isEmpty()) {
                res = new ArrayList<>();
                level = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return result;
    }
}
