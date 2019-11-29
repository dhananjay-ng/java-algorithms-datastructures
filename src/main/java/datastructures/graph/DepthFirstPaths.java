package datastructures.graph;

import java.util.Arrays;
import java.util.Stack;


public class DepthFirstPaths implements Paths {

    boolean[] marked;
    int[] edgeTo;
    int s;

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        Arrays.fill(edgeTo, -1);
        dfs(G, s);
    }

    public DepthFirstPaths(Graph G) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        Arrays.fill(edgeTo, -1);
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        for (int i : g.adj(v)) {
            if (!marked[i]) {
                dfs(g, i);
                edgeTo[i] = v;
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
