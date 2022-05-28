package graph;

import java.util.*;

public class MyGraph {
    private LinkedList< Node > vertexs;
    private int idstart = 0;
    /**
     * constructor of graph
     */
    public MyGraph() {
        vertexs = new LinkedList<>();
    }
    /**
     * create new vertex
     * @param label : vertex label 
     * @param weight : vertex weight
     * @return new vertex
     */
    public Node newVertex(String label,double weight) {
        Node n=  new Node(label, weight,idstart);
        idstart++;
        return n;
    }
    /**
     * add new vertex to graph
     * @param v : vertex 
     */
    public void addVertex(Node v) {
        for(Node i : vertexs) {
            if(v.getName().equals(i.getName()))
                return;
        }
        vertexs.add(v);
    }

    public boolean AddEdge(int v1, int v2, int weight) {
        int count = 0;
        int i1 = -1, i2 = -1;
        for(Node v : vertexs) {
            if(v.getId() == v1 ) {
                i1 = count;
            }
            else if(v.getId() == v2) {
                i2 = count;
            }
            count++;
        }
        if( i1 == -1 || i2 == -1 ) {
            System.out.println("invalid vertex id");
            return false;
        }
        
        vertexs.get(i1).getEdges().add(new Edge(vertexs.get(i2).getNode(),weight));
        vertexs.get(i2).getEdges().add(new Edge(vertexs.get(i1).getNode(),weight));
        
        return true;
    }
    
    public boolean removeEdge(int v1, int v2) {
        int count = 0;
        int i1 = -1, i2 = -1;
        for(Node v : vertexs) {
            if(v.getId() == v1 ) {
                i1 = count;
            }
            else if(v.getId() == v2) {
                i2 = count;
            }
            count++;
        }

        if( i1 == -1 || i2 == -1 ) {
            System.out.println("invalid vertex id");
            return false;
        }
        if(vertexs.get(i1).getEdge(v2) != null)
            vertexs.get(i1).getEdges().remove(vertexs.get(i1).getEdge(v2));
        if(vertexs.get(i2).getEdge(v1) != null)
            vertexs.get(i2).getEdges().remove(vertexs.get(i2).getEdge(v1));
        
        return true;
    }
    
    public boolean removeVertex(int vid) {
        int count = 0;
        int i1 = -1;
        for(Node v : vertexs) {
            if(v.getId() == vid ) {
                i1 = count;
            }
            count++;
        }
        //check the vertex is finded
        if(i1 == -1) {
            System.out.println("vertex not found");
        }
        //delete all links
        for(int i=0;i<vertexs.size();i++) {
            if(vertexs.get(i).getEdge(vid) != null)
                vertexs.get(i1).getEdges().remove(vertexs.get(i).getEdge(vid));
        }
        //delete vertex
        vertexs.remove(i1);
        return false;
    }

    public boolean removeVertex(String label) {
        int count = 0;
        int i1 = -1;
        int vid=-1;
        for(Node v : vertexs) {
            if(v.getName() == label ) {
                vid = v.getId();
                i1 = count;
            }
            count++;
        }
        //check the vertex is finded
        if(i1 == -1) {
            System.out.println("vertex not found");
        }
        //delete all links
        for(int i=0;i<vertexs.size();i++) {
            if(vertexs.get(i).getEdge(vid) != null)
                vertexs.get(i1).getEdges().remove(vertexs.get(i).getEdge(vid));
        }
        //delete vertex
        vertexs.remove(i1);
        return false;
    }

    public int[][] exportMatrix() {
        int[][] matrix =new int[vertexs.size()][vertexs.size()];
        for(int i=0;i<vertexs.size();i++) {
            for(int j=0;j<vertexs.size();j++) {
                if(vertexs.get(i).getEdge(vertexs.get(j).getId()) == null) {
                    matrix[i][j] = 0;
                } else{
                    matrix[i][j] = 1;
                }

            }
        }
        return matrix;
    }

    public void printGraph() {
        for (Node v: vertexs) {
            System.out.print("vertex name: [" + v.getName() +"]" );
            for (Edge e: v.getEdges()) {
                System.out.print(" -> [" + e.getDest().getName() + "|" + e.getWeight()+"]");
            }
            System.out.print("\n");
        }
    }



   public static void main(String[] args) {
       System.out.println(" ");
        MyGraph ourGraph = new MyGraph();

        ourGraph.addVertex(ourGraph.newVertex("murat1", 5));
        ourGraph.addVertex(ourGraph.newVertex("murat2", 5));
        ourGraph.addVertex(ourGraph.newVertex("murat3", 5));
        ourGraph.addVertex(ourGraph.newVertex("murat4", 5));

        ourGraph.AddEdge(0, 1, 5);
        ourGraph.AddEdge(1, 2, 6);
        ourGraph.AddEdge(2, 3, 7);
        ourGraph.AddEdge(0, 2, 8);
        ourGraph.printGraph();

        System.err.println("after deletion");
        //ourGraph.removeEdge(0, 1);
        
        //ourGraph.removeVertex(0);
        //ourGraph.removeVertex("murat3");
        System.out.println(Arrays.deepToString(ourGraph.exportMatrix()));        
    }

}
