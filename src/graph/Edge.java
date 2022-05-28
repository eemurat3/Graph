package graph;

public class Edge {
    private Node dest;
    private int weight;
    private int edgeId;

    //Constructs an Edge from source to dest . Sets the weight to w
    public Edge(Node dest, int w) {
        this.dest = dest;
        this.weight = w;
        edgeId = dest.getId();
    }
    /**
     * Returns the destination vertex
     * @return
     */
    public Node getDest() {
        return dest;
    }
    /**
     * Returns the weight
     * @return
     */
    public int getWeight(){
        return weight;
    }

    public Edge getEdge() {
        return this;
    }

    public int getEdgeId() {
        return edgeId;
    }

}
