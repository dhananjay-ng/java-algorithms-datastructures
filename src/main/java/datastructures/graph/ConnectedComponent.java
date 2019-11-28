package datastructures.graph;

public class ConnectedComponent {

    private int ccCount;
    private boolean[] marked;
    private int[] cc;

    public ConnectedComponent(Graph G) {
        marked = new boolean[G.V()];
        cc = new int[G.V()];
        ccCount = 0;
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                ccCount++;
                dfs(G, i);
            }
        }
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        cc[v] = ccCount;
        for (int i : g.adj(v)) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    public boolean connected(int v, int w) {
        return cc[v] == cc[w];
    }

    public int count() {
        return this.ccCount;
    }

    public int id(int v) {
        return cc[v];
    }

}
