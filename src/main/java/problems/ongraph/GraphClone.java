package problems.ongraph;


import java.util.*;

public class GraphClone {

    public static class GraphVertex {
        public int label;
        public List<GraphVertex> edges;

        public GraphVertex(int label) {
            this.label = label;
            edges = new ArrayList<>();
        }
    }

    public static GraphVertex cloneGraph(GraphVertex graph) {

        if (graph == null) {
            return null;
        }

        Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> q = new ArrayDeque<>();
        q.add(graph);
        vertexMap.put(graph, new GraphVertex(graph.label));
        while (!q.isEmpty()) {
            GraphVertex v = q.remove();
            for (GraphVertex e : v.edges) {
                // Try to copy vertex e.
                if (vertexMap.putIfAbsent(e, new GraphVertex(e.label)) == null) {
                    q.add(e);
                }
                // Copy edge.
                vertexMap.get(v).edges.add(vertexMap.get(e));
            }
        }
        return vertexMap.get(graph);
    }
}

