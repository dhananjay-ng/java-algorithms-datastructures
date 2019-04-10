package problems.onbinarytree;

import java.util.Deque;
import java.util.LinkedList;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(p.equals(q)) return p;

        Deque<TreeNode> pathToP = pathToNode(root, p);
        Deque<TreeNode> pathToQ = pathToNode(root, q);
        if(pathToP == null || pathToQ == null)
            return null;

        TreeNode prev = null;
        while(!pathToP.isEmpty() && !pathToQ.isEmpty()) {
            if(pathToP.peekFirst().equals(pathToQ.peekFirst())) {
                prev =  pathToP.removeFirst();
                pathToQ.removeFirst();
            }else{
                break;
            }
        }

        return prev;
    }

    private Deque<TreeNode> pathToNode(TreeNode root, TreeNode desti) {
        if(root == null)
            return null;
        if(root.equals(desti)) {
            Deque<TreeNode> path = new LinkedList<>();
            path.addFirst(root);
            return path;
        }

        Deque<TreeNode> lpath =  pathToNode(root.left, desti);
        Deque<TreeNode> rpath =  null;
        if(lpath == null){
            rpath=   pathToNode(root.right, desti);
        }
        if(lpath !=null ){
            lpath.addFirst(root);
            return lpath;
        } else if(rpath != null) {
            rpath.addFirst(root);
            return rpath;
        }
        return null;

    }


}
