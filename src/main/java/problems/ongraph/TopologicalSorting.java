package problems.ongraph;

import datastructures.graph.DepthFirstPaths;
import datastructures.graph.Digraph;
import datastructures.graph.Graph;

import java.util.Arrays;
import java.util.Stack;

public class TopologicalSorting {
    boolean[] marked;
    int s;
    Stack<Integer> topoOrder;

    public TopologicalSorting(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        topoOrder = new Stack<>();
        dfs(G, s);
    }


    public void dfs(Graph g, int v) {
        marked[v] = true;
        for (int i : g.adj(v)) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
        topoOrder.push(v);
    }

    public static void main(String[] args) {
        Graph graph = new Digraph(5);

        /**
         *   4<--0-->1-->2
         *   |
         *   3-->2
         *
         */

        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
   //     graph.addEdge(2, 0);
//        graph.addEdge(3, 2);
//        graph.addEdge(4, 3);
//        graph.addEdge(0, 4);

        TopologicalSorting topologicalSorting = new TopologicalSorting(graph, 0);
        topologicalSorting.topoOrder.forEach(integer -> System.out.println(integer));
    }
}
