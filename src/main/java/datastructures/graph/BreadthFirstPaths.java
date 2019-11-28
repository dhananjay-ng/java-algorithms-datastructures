package datastructures.graph;

import java.util.*;

public class BreadthFirstPaths  implements Paths{

    boolean[] marked;
    int[] edgeTo;
    int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        Arrays.fill(edgeTo, -1);
        bfs(G, s);
    }

    private void bfs(Graph g, int v) {
        marked[v] = true;
        Deque<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(v);

        while (!nodeQueue.isEmpty()) {
            int currentNode = nodeQueue.removeFirst();
            for (int adjacentNode : g.adj(currentNode)) {
                if (!marked[adjacentNode]) {
                    nodeQueue.addLast(adjacentNode);
                    marked[adjacentNode] = true;
                    edgeTo[adjacentNode] = currentNode;
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        while (edgeTo[v] != this.s) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(this.s);
        return path;
    }
}
