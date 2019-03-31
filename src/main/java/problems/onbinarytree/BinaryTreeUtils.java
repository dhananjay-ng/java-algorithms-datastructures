package problems.onbinarytree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Objects;
import java.util.Set;

public class BinaryTreeUtils {
    public static class TreePath {
        private TreePath prev;
        private boolean toLeft;

        public TreePath() {}

        private TreePath(TreePath prev, boolean toLeft) {
            this.prev = prev;
            this.toLeft = toLeft;
        }

        public TreePath withLeft() { return new TreePath(this, true); }

        public TreePath withRight() { return new TreePath(this, false); }

        @Override
        public String toString() {
            if (prev == null) {
                return "root";
            }

            return prev.toString() + (toLeft ? "->left" : "->right");
        }
    }

    private static void treeGenerateHelper(Object tree, List<Object> result,
                                           int order) {
        if (tree != null) {
            if (order == -1) {
                result.add(getData(tree));
            }
            treeGenerateHelper(getLeft(tree), result, order);
            if (order == 0) {
                result.add(getData(tree));
            }
            treeGenerateHelper(getRight(tree), result, order);
            if (order == 1) {
                result.add(getData(tree));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <Node> List<Node> generatePreorder(Object tree) {
        List<Object> result = new ArrayList<>();
        treeGenerateHelper(tree, result, -1);
        return (List<Node>)result;
    }

    @SuppressWarnings("unchecked")
    public static <Node> List<Node> generateInorder(Object tree) {
        List<Object> result = new ArrayList<>();
        treeGenerateHelper(tree, result, 0);
        return (List<Node>)result;
    }

    @SuppressWarnings("unchecked")
    public static <Node> List<Node> generatePostorder(Object tree) {
        List<Object> result = new ArrayList<>();
        treeGenerateHelper(tree, result, 1);
        return (List<Node>)result;
    }

    private static Object findNode(Object node, Object val) {
        if (node != null) {
            if (val.equals(getData(node))) {
                return node;
            }

            Object leftResult = findNode(getLeft(node), val);
            if (leftResult != null) {
                return leftResult;
            }

            Object rightResult = findNode(getRight(node), val);
            if (rightResult != null) {
                return rightResult;
            }
        }

        return null;
    }

    public static <Node> Node mustFindNode(Node tree, Object val) {
        @SuppressWarnings("unchecked") Node result = (Node)findNode(tree, val);
        if (result == null) {
            throw new RuntimeException(String.valueOf(val) +
                    " was not found in the tree");
        }
        return result;
    }

    public static boolean isObjectTreeType(Object tree) {
        return tree != null &&
                (tree instanceof BinaryTree || tree instanceof BinaryTreeNode ||
                        tree instanceof BstNode);
    }

    public static boolean equalBinaryTrees(Object node1, Object node2) {
        if (node1 != null && node2 != null) {
            return Objects.equals(getData(node1), getData(node2)) &&
                    equalBinaryTrees(getLeft(node1), getLeft(node2)) &&
                    equalBinaryTrees(getRight(node1), getRight(node2));
        } else {
            return node1 == null && node2 == null;
        }
    }

    public static String binaryTreeToString(Object tree) {
        StringBuilder result = new StringBuilder();
        Queue<Object> q = new LinkedList<>();
        Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        boolean first = true;
        int nullNodesPending = 0;

        result.append("[");
        q.add(tree);

        while (!q.isEmpty()) {
            Object node = q.poll();
            if (visited.contains(node)) {
                throw new RuntimeException("Detected a cycle in the tree");
            }
            if (node != null) {
                if (first) {
                    first = false;
                } else {
                    result.append(", ");
                }

                while (nullNodesPending > 0) {
                    result.append("null, ");
                    nullNodesPending--;
                }

                result.append('"').append(getData(node)).append('"');

                visited.add(node);
                q.add(getLeft(node));
                q.add(getRight(node));
            } else {
                nullNodesPending++;
            }
        }

        result.append("]");
        return result.toString();
    }

    public static <Node> int binaryTreeHeight(Node tree) {
        if (tree == null) {
            return -1;
        }
        return 1 + Math.max(binaryTreeHeight(getLeft(tree)),
                binaryTreeHeight(getRight(tree)));
    }

    public static <Node> int binaryTreeSize(Node tree) {
        if (tree == null) {
            return 0;
        }

        return 1 + binaryTreeSize(getLeft(tree)) + binaryTreeSize(getRight(tree));
    }

    // Java framework specific methods

    /**
     * Dirty hacks to overcome the fact that binary tree classes don't have a
     * common interface
     */
    private static Object getData(Object tree) {
        if (tree == null) {
            return null;
        }
        if (tree instanceof BinaryTreeNode) {
            return ((BinaryTreeNode<?>)tree).data;
        }
        if (tree instanceof BinaryTree) {
            return ((BinaryTree<?>)tree).data;
        }
        if (tree instanceof BstNode) {
            return ((BstNode<?>)tree).data;
        }
        throw new RuntimeException("Unsupported binary tree type: " +
                tree.getClass().getName());
    }

    private static Object getLeft(Object tree) {
        if (tree == null) {
            return null;
        }
        if (tree instanceof BinaryTreeNode) {
            return ((BinaryTreeNode<?>)tree).left;
        }
        if (tree instanceof BinaryTree) {
            return ((BinaryTree<?>)tree).left;
        }
        if (tree instanceof BstNode) {
            return ((BstNode<?>)tree).left;
        }
        throw new RuntimeException("Unsupported binary tree type: " +
                tree.getClass().getName());
    }

    private static Object getRight(Object tree) {
        if (tree == null) {
            return null;
        }
        if (tree instanceof BinaryTreeNode) {
            return ((BinaryTreeNode<?>)tree).right;
        }
        if (tree instanceof BinaryTree) {
            return ((BinaryTree<?>)tree).right;
        }
        if (tree instanceof BstNode) {
            return ((BstNode<?>)tree).right;
        }
        throw new RuntimeException("Unsupported binary tree type: " +
                tree.getClass().getName());
    }

    public static BinaryTreeNode<Integer> getSampleTree(int levels) {
        BinaryTreeNode<Integer> sample = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>();

        //level 0
        root.data = 1;

        if (levels == 0) return root;
        //level 1
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);

        if (levels == 1) return root;

        //level 2
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        if (levels == 2) return root;

        //level 2
        root.left.left.left = new BinaryTreeNode<>(8);
        root.left.left.right = new BinaryTreeNode<>(9);
        root.left.right.left = new BinaryTreeNode<>(10);
        root.left.right.right = new BinaryTreeNode<>(11);
        root.right.left.left = new BinaryTreeNode<>(12);
        root.right.left.right = new BinaryTreeNode<>(13);
        root.right.right.left = new BinaryTreeNode<>(14);
        root.right.right.right = new BinaryTreeNode<>(15);
        if (levels == 3) return root;

        //level 3
        root.left.left.left.left = new BinaryTreeNode<>(16);
        root.left.left.left.right = new BinaryTreeNode<>(17);
        root.left.left.right.left = new BinaryTreeNode<>(18);
        root.left.left.right.right = new BinaryTreeNode<>(19);
        root.left.right.left.left = new BinaryTreeNode<>(20);
        root.left.right.left.right = new BinaryTreeNode<>(21);
        root.left.right.right.left = new BinaryTreeNode<>(22);
        root.left.right.right.right = new BinaryTreeNode<>(23);
        root.right.left.left.left = new BinaryTreeNode<>(24);
        root.right.left.left.right = new BinaryTreeNode<>(25);
        root.right.left.right.left = new BinaryTreeNode<>(26);
        root.right.left.right.right = new BinaryTreeNode<>(27);
        root.right.right.left.left = new BinaryTreeNode<>(28);
        root.right.right.left.right = new BinaryTreeNode<>(29);
        root.right.right.right.left = new BinaryTreeNode<>(30);
        root.right.right.right.right = new BinaryTreeNode<>(31);


        return root;
    }
}
