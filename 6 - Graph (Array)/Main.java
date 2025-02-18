
public class Main {

    public static void main(String[] args) {
        
        Graph graph = new Undirected(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(3, 4);
        graph.removeEdge(0, 3);

        graph.showEdges();
    }   
}