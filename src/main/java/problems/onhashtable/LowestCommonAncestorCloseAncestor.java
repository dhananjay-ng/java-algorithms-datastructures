package problems.onhashtable;

import problems.onbinarytree.BinaryTree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorCloseAncestor {

    /**
     * moving upwards from
     * the two nodes and storing the nodes visited as we move up in a hash table. Each time
     * we visit a node we check to see if it has been visited before.
     */
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        Set<BinaryTree<Integer>> hash = new HashSet<>();
        while (node0 != null || node1 != null) {
            if (node0 != null) {
                if (!hash.add(node0)) {
                    return node0;
                }
                node0 = node0.parent;
            }
            if (node1 != null) {
                if (!hash.add(node1)) {
                    return node1;
                }
                node1 = node1.parent;
            }

        }
        return null;
    }
}

