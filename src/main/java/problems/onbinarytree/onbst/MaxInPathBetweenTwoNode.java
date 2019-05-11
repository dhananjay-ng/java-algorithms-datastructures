package problems.onbinarytree.onbst;

import java.io.IOException;
import java.util.Scanner;

public class MaxInPathBetweenTwoNode {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDINbs
        websites.he.tree.BST<Integer> bst = new websites.he.tree.BST<>();
        for (int i = 0; i < n; i++) {
            bst.add(s.nextInt());
        }

        int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(bst.maxOnPathBetweenTwoNodes(x,y));

    }
    /**
     * public Key maxOnPathBetweenTwoNodes(Key x, Key y) {
     *         Node iter = root;
     *         while (iter!=null) {
     *             if (x.compareTo(iter.key) < 0 && y.compareTo(iter.key) < 0){
     *                 iter = iter.left;
     *             } else if (x.compareTo(iter.key) > 0 && y.compareTo(iter.key) > 0) {
     *                 iter = iter.right;
     *             } else {
     *                 break;
     *             }
     *         }
     *         Node pathRoot = iter;
     *         if (pathRoot == null){
     *             pathRoot = root;
     *         }
     *         Key max = pathRoot.key;
     *         iter = pathRoot;
     *         while (iter!=null) {
     *             if (x.compareTo(iter.key) > 0){
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 iter = iter.right;
     *             } else if (x.compareTo(iter.key) < 0){
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 iter= iter.left;
     *             } else {
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 break;
     *             }
     *         }
     *         iter = pathRoot;
     *         while (iter!=null) {
     *             if (y.compareTo(iter.key) > 0){
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 iter = iter.right;
     *             } else if (y.compareTo(iter.key) < 0){
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 iter= iter.left;
     *             } else {
     *                 max = max.compareTo(iter.key) > 0 ? max:iter.key;
     *                 break;
     *             }
     *         }
     *         return max;
     *
     *     }
     */
}
