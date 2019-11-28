package datastructures.graph;

public interface Graph {

     void addEdge(int vertex1, int vertex2);

     Iterable<Integer> adj(int vertex);

     //number of vertices
     int V();

     //number of edges
     int E();


}
