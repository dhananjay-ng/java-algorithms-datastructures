package problems.onbinarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class PostOrder {

    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null) return res;
        TreeNode prevLeft = null;
        TreeNode prevRight = null;

        Deque<TreeNode> deq = new LinkedList<>();
        deq.addLast(A);
        HashSet<TreeNode> seen = new HashSet<>();
        while(!deq.isEmpty()) {
            while(deq.peekLast().left != null && !seen.contains(deq.peekLast().left)) {
                deq.addLast(deq.peekLast().left);
            }

            if(deq.peekLast().right != null) {
                if(seen.contains(deq.peekLast().right)){
                    TreeNode child = deq.removeLast();
                    res.add(child.val);
                    seen.add(child);
                } else {
                    deq.addLast(deq.peekLast().right);
                }
            } else {
                TreeNode child = deq.removeLast();
                res.add(child.val);
                seen.add(child);
            }

        }
        //helper(A, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        //level 0
        root.val = 1;

        //level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        //level 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        postorderTraversal(root).forEach(System.out::println);
    }
}
