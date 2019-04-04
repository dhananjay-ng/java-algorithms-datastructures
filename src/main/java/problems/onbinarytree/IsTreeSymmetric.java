package problems.onbinarytree;

import java.util.Deque;
import java.util.LinkedList;

public class IsTreeSymmetric {
    public boolean isSymmetric(TreeNode root) {
         if(root == null) return true;
         Deque<TreeNode> st = new LinkedList<>();
         st.addFirst(root.left);
         st.addFirst(root.right);
         while(!st.isEmpty()) {
             TreeNode t1,t2;
             t1= st.removeFirst();
             t2 = st.removeFirst();
             if(t1 == null && t2 == null && st.isEmpty()) break;
             if(t1 == null && t2 == null && !st.isEmpty()) continue;
             if(t1 == null && t2 != null) return false;
             if(t1 != null && t2 == null) return false;
             if(t1.val != t2.val) return false;
             st.addFirst(t1.left);
             st.addFirst(t2.right);
             st.addFirst(t1.right);
             st.addFirst(t2.left);
         }
         return true;

    }

    public boolean isSymmetricRecursive(TreeNode t1, TreeNode t2) {
        if((t1==null && t2!=null) || (t1!=null && t2==null)) return false;
        if(t1==null && t2==null) return true;
        if(t1.val != t2.val) return false;

        return (isSymmetricRecursive(t1.left,t2.right) & isSymmetricRecursive(t1.right,t2.left)) ;
    }
}
