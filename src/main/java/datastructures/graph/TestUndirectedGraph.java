package datastructures.graph;

public class TestUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new UndirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        // graph.adj(1).forEach(integer -> System.out.println(integer));
        System.out.println(graph.toString());

        Paths depthFirstPaths = new DepthFirstPaths(graph, 0);
        System.out.println(depthFirstPaths.hasPathTo(4));

        System.out.println();
        System.out.println("DFS");
        for (int path : depthFirstPaths.pathTo(4)) {
            System.out.print(path + "->");
        }

        Paths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        System.out.println();
        System.out.println("BFS");
        for (int path : breadthFirstPaths.pathTo(4)) {
            System.out.print(path + "->");
        }


        Graph graph2 = new UndirectedGraph(13);

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 5);
        graph2.addEdge(0, 6);
        graph2.addEdge(6, 4);
        graph2.addEdge(5, 3);
        graph2.addEdge(4, 3);
        graph2.addEdge(5, 4);

        graph2.addEdge(7, 8);

        graph2.addEdge(9, 11);
        graph2.addEdge(9, 12);
        graph2.addEdge(9, 10);
        graph2.addEdge(11, 12);


        graph = new Digraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        // graph.adj(1).forEach(integer -> System.out.println(integer));
        System.out.println(graph.toString());

        depthFirstPaths = new DepthFirstPaths(graph, 0);
        System.out.println(depthFirstPaths.hasPathTo(4));

        System.out.println();
        System.out.println("DFS");
        for (int path : depthFirstPaths.pathTo(4)) {
            System.out.print(path + "->");
        }

        breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        System.out.println();
        System.out.println("BFS");
        for (int path : breadthFirstPaths.pathTo(4)) {
            System.out.print(path + "->");
        }


        ConnectedComponent connectedComponent = new ConnectedComponent(graph2);

        System.out.println();

        System.out.println("Number of Connected Components : " + connectedComponent.count());
        System.out.println("Connected 0 & 6 : " + connectedComponent.connected(0, 6));
        System.out.println("Connected 0 & 8 : " + connectedComponent.connected(0, 8));
        System.out.println("Component of 4 : " + connectedComponent.id(4));
        System.out.println("Component of 7 : " + connectedComponent.id(7));
        System.out.println("Component of 12 : " + connectedComponent.id(12));


    }
}
