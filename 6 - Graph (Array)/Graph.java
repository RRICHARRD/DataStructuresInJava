
/**
 * Graph data structure implemented
 * 
 * <p>See the diagram below for a visual representation:</p>
 * <img src="Useful/Teory.jpg" alt="Graph representation" width="50" height="50">
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public abstract class Graph {

    private int vertices;
    protected int graph[][];

    /**
     * Class constructor
     */
    public Graph(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
    }

    /**
     * @return Quantity of vertices present in the datastructure
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * Define an edge betewen two vertices
     * 
     * @param origin
     * @param destination 
     */
    public abstract void addEdge(int origin, int destination);

    /**
     * Remove an edge between two vertices
     * 
     * @param origin
     * @param destination
     */
    public abstract void removeEdge(int origin, int destination);

    /**
     * Print columns indentification
     */
    private void showColumns() {
        for (int column=0; column < this.getVertices(); column++)
            System.err.print(String.format(column == 0 ? "  %d" : " %d", column));
        System.out.println();
    }

    /**
     * Show all edges relantionships between vertices
     */
    public void showEdges() {
        this.showColumns();

        for (int line=0; line < this.vertices ; line++) {
            System.out.print(line);
            for (int column=0; column < this.vertices ; column++) {
                System.out.print(String.format(" %d", this.graph[line][column]));
            }
            System.out.println();
        }
    }

    /**
     * Check if vertice is present inside the graph collection
     * 
     * @param vertice
     * @return true if vertice exists
     */
    protected boolean isVertice(int vertice) {
        return vertice >= 0 && vertice < this.getVertices();
    }

}