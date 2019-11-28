package datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph implements Graph {

    int vertices;
    int edges;
    List<Integer>[] adj;

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new ArrayList<>();

    }

    @Override
    public void addEdge(int from, int to) {
        this.edges++;
        this.adj[from].add(to);
        this.adj[to].add(from);

    }

    @Override
    public Iterable<Integer> adj(int vertex) {
        return this.adj[vertex];
    }

    @Override
    public int V() {
        return this.vertices;
    }

    @Override
    public int E() {
        return this.edges;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("-------Graph-------\n");

        for (int i = 0; i < this.vertices; i++) {
            stringBuilder.append(i).append(adj[i].toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
