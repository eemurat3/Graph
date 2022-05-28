package graph;
import java.util.*;

class Node {
    private Vertex vertex;
    private LinkedList < Edge > edgeList;

    public Node(String label,double weight,int id) {
        vertex = new Vertex(label, weight, id);
        edgeList = new LinkedList <> ();
    }

    public String getName() {
        return vertex.getLabel();
    }

    public int getId() {
        return vertex.getId();
    }

    public LinkedList < Edge > getEdges() {
        return edgeList;
    }

    public Edge getEdge(int id) {
        for(Edge e : edgeList) {
            if(e.getEdgeId() == id){
                return e;
            }
        }
        return null;
    }
    public Node getNode() {
        return this;
    }


}
