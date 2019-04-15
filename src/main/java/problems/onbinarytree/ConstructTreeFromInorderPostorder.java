package problems.onbinarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructTreeFromInorderPostorder {
    /***
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length <= 0 || postorder.length <= 0)
                return null;

            Map<Integer, Integer> inordermap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inordermap.put(inorder[i], i);
            }

            return helper(inorder, postorder, inordermap, 0,
                    inorder.length - 1, 0, postorder.length - 1);
        }

        public TreeNode helper(int[] inorder, int[] postorder, Map<Integer, Integer> inordermap, int instart, int inend, int poststart, int postend) {

            if (inend < instart || postend < poststart) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postend]);

            int idx = inordermap.get(root.val);

            root.left = helper(inorder, postorder, inordermap,
                    instart, idx - 1,
                    poststart, poststart + idx - instart - 1);

            root.right = helper(inorder, postorder, inordermap,
                    idx + 1, inend,
                    poststart + idx - instart, postend - 1);

            return root;
        }
    }


    //solution2
    class Index {
        int index;
    }

    class Solution2 {
        HashMap<Integer, Integer> hm;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int length = inorder.length;
            TreeNode node;
            Index i = new Index();
            i.index = length - 1;
            hm = new HashMap<Integer, Integer>();
            for (int j = 0; j < length; j++) {
                hm.put(inorder[j], j);
            }
            node = buildUtil(inorder, postorder, 0, length - 1, i);
            return node;
        }

        public TreeNode buildUtil(int[] inorder, int[] postorder, int s, int e, Index index) {
            if (s > e) {
                return null;
            }
            TreeNode n = new TreeNode(postorder[index.index]);
            index.index--;
            if (s == e) {
                return n;
            }
            int pos = hm.get(n.val);
            n.right = buildUtil(inorder, postorder, pos + 1, e, index);
            n.left = buildUtil(inorder, postorder, s, pos - 1, index);
            return n;
        }

    }

    class Solution3 {
        /*
          The core idea is: Starting from the last element of the postorder and inorder array,
          we put elements from postorder array to a stack and each one is the right child of the last one
          until an element in postorder array is equal to the element on the inorder array.
          Then, we pop as many as elements we can from the stack and decrease the mark in inorder array until the peek()
          element is not equal to the mark value or the stack is empty.
          Then, the new element that we are gonna scan from postorder array is the left child of the last element we have popped out from the stack.
         */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0) return null;
            int ip = inorder.length - 1;
            int pp = postorder.length - 1;

            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;
            TreeNode root = new TreeNode(postorder[pp]);
            stack.push(root);
            pp--;

            while (pp >= 0) {
                while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                    prev = stack.pop();
                    ip--;
                }
                TreeNode newNode = new TreeNode(postorder[pp]);
                if (prev != null) {
                    prev.left = newNode;
                } else if (!stack.isEmpty()) {
                    TreeNode currTop = stack.peek();
                    currTop.right = newNode;
                }
                stack.push(newNode);
                prev = null;
                pp--;
            }

            return root;
        }
    }
}
