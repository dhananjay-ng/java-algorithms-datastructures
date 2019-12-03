package problems.ongraph;

import java.util.ArrayList;
import java.util.List;

public class DeadlockDetection {
    public static enum Color {WHITE, GRAY, BLACK};

    public static class GraphVertex {
        public List<GraphVertex> edges;
        Color color;

        public GraphVertex() {
            edges = new ArrayList<>();
            this.color = Color.WHITE;
        }
    }

    public static boolean isDeadlocked(List<GraphVertex> graph) {

        for (GraphVertex g : graph) {
            if (g.color == Color.WHITE && hasCycle(g)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(GraphVertex g) {
        if (g.color == Color.GRAY)
            return true;

        g.color = Color.GRAY;
        for (GraphVertex path : g.edges) {
            if (path.color != Color.BLACK)
                if (hasCycle(path)) return true;
        }
        g.color = Color.BLACK;
        return false;
    }

    /**
     * High performance database systems use multiple processes and resource locking.
     * These systems may not provide mechanisms to avoid or prevent deadlock: a situation
     * in which two or more competing actions are each waiting for the other to finish,
     * which precludes all these actions from progressing. Such systems must support a
     * mechanism to detect deadlocks, as well as an algorithm for recovering from them.
     * One deadlock detection algorithm makes use of a "wait-for " graph to track which
     * other processes a process is currently blocking on. In a wait-for graph, processes
     * are represented as nodes, and an edge from process P to 0 implies 0 is holding a
     * resource that P needs and thus P is waiting for 0 to release its lock on that resource. A
     * cycle in this graph implies the possibility of a deadlock. This motivates the following
     * problem.
     * Write a program that takes as input a directed graph and checks if the graph contains
     * a cycle.
     *
     * We can check for the existence of a cycle in G by running DFS on G. Recall
     * DFS maintains a color for each vertex. Initially, all vertices are white. When a vertex
     * is first discovered, it is colored gray. When DFS finishes processing a vertex, that
     * vertex is colored black.
     * As soon as we discover an edge from a gray vertex back to a gray vertex, a cycle
     * exists in G and we can stop. Conversely, if there exists a cycle, once we first reach
     * vertex in the cycle (call it v), we will visit its predecessor in the cycle (call it u) before
     * finishing processing v, i.e., we will find an edge from a gray to a gray vertex. In
     * summary, a cycle exists if and only if DFS discovers an edge from a gray vertex to a
     * gray vertex. Since the graph may not be strongly connected, we must examine each
     * vertex, and run DFS from it if it has not already been explored.
     *
     * Variant: Solve the same problem for an undirected graph.
     * Ans : locic will remain same
     *
     *
     * Variant: Write a program that takes as input an undirected graph, which you can
     * assume to be connected, and checks if the graph remains connected if any one edge
     * is removed.
     * Ans : this about connected component
     */
}
