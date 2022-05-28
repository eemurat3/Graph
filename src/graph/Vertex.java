package graph;

public class Vertex {
	/**
	 * label for Vertex
	 */
	private String name;  
    /**
     * weight of the vertex
     */
    private double weight;
    /**
     * vertex id;
     */
    private int id;

	public static final int INFINITY = Integer.MAX_VALUE;

	public Vertex(String v,double w,int i)
	{
		name = v;
        weight = w;
        id = i;

	}

    public String getLabel() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

	public String toString()
	{ 
		return name;
	}
}

