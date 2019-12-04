package problems.ongraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectCycleInGraph {
    class Vertex {
        int index;
        int colour;

        Vertex(int l) {
            index = l;
            colour = 0;
        }
    }
    class Graph {
        HashMap<Integer, Vertex> map = new HashMap<>();
        List<Vertex>[] adj;

        Graph(int vertices) {
            adj = new ArrayList[vertices + 1];
            for (int i = 0; i < vertices + 1; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdge(int from, int to) {
            Vertex v1 = null;
            if (!map.containsKey(from)) {
                v1 = new Vertex(from);
                map.put(from, v1);
            }
            Vertex v2 = null;
            if (!map.containsKey(to)) {
                v2 = new Vertex(to);
            } else {
                v2 = map.get(to);
            }
            this.adj[from].add(v2);
        }
    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Graph g = new Graph(A);
        for (int i = 0; i < B.size(); i++)
            g.addEdge(B.get(i), C.get(i));

        for (int i = 0; i < B.size(); i++) {
            for (Vertex cu : g.adj[B.get(i)]) {
                int ans = -1;
                if (cu.colour == 0)
                    ans = DFS(g, cu);
                if (ans == 0)
                    return 0;
            }
        }
        return 1;
    }

    private int DFS(Graph g, Vertex v) {
        if (v.colour == 1) return 0;
        v.colour = 1;
        for (Vertex v2 : g.adj[v.index]) {
            if (v2.colour != 2) {
                if (DFS(g, v2) == 0) {
                    return 0;
                }
            }
        }
        v.colour = 2;
        return 1;
    }
}
