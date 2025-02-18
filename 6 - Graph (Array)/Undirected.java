
/**
 * Implementation of graph undirected
 * 
 * <p>See the diagram below for a visual representation:</p>
 * <img src="Useful/Graph Definition.png" alt="Graph representation" width="50" height="50">
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public class Undirected extends Graph {

    /**
     * Class constructor
     * 
     * @param vertices Quantity of vertices
     */
    public Undirected(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int origin, int destination) {
        if (!this.isVertice(origin) || !this.isVertice(destination)) 
            throw new UnsupportedOperationException(String.format("Vertice is out of the range. Please use number between 0 and %d.", this.getVertices() - 1));
        this.graph[origin][destination] = 1;
        this.graph[destination][origin] = 1;
    }

    @Override
    public void removeEdge(int origin, int destination) {
        if (!this.isVertice(origin) || !this.isVertice(destination)) 
            throw new UnsupportedOperationException(String.format("Vertice is out of the range. Please use number between 0 and %d.", this.getVertices() - 1));
        this.graph[origin][destination] = 0;
        this.graph[destination][origin] = 0;
    }
}