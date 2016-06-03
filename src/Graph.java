import java.util.HashMap;
import java.util.List;

public class Graph<T> implements BasicGraphADT<T> {

	private HashMap<Integer,Vertex<T>> verts;
	//private List<Vertex<T>,Vertex<T>> edges;
	private int vertCount;
	private int edgeCount;

	public Graph() {
		this.verts = new HashMap<Integer,Vertex<T>>();
		this.vertCount = 0;
		this.edgeCount = 0;
	}

	/*******************
	 * Add a vertex to this graph with given label
	 * @return Whether the vertex was successfully added
	 ********************/
	public boolean addVertex(T vert) {
		this.verts.add(vert);
	}

	/******************
	 * Add an edge to this graph between the two given labels
	 * @return Whether the edge was successfully added
	 ********************/
	public boolean addEdge(T beg, T end) {
		this.vert.add(beg, end);
	}

	/******************
	 * Tests whether a vertex exists in the graph
	 * @return Whether the vertex exists
	 ********************/
	public boolean hasVertex(T vert) {
		for(int i = 0; i < this.vertCount; i++) {
			if(this.verts.get(i).equals(vert)) {
				return true;
			}
		}
		return false;
	}


	/******************
	 * Tests whether an edge exists in the graph
	 * @return Whether the edge exists
	 ********************/
	public boolean hasEdge(T beg, T end) {
		for(int i = 0; i < this.edgeCount; i++) {
			if(this.edges.get(i).equals()) {
				return true;
			}
		}
		return false;
	}


	/*****************
	 * Gets a list containing all the neighbors of a given vertex
	 * @return the neighbor list as a java List
	 *********************/
	public List<Vertex<T>> getNeighbors(T vert) {

	}

	/****************************
	 * Gets the vertex object associated with the given label
	 * @return the vertex
	 ************************/
	public Vertex<T> getVertex(T lab) {

	}

	/*****************
	 * Tests if the graph is empty
	 * @return Whether the graph is empty
	 *******************/
	public boolean isEmpty() {

	}

	/********************
	 * Gets the number of vertices
	 * @return The number of vertices
	 *******************/
	public int getNumVertices() {

	}

	/********************
	 * Gets the number of edges
	 * @return The number of edges
	 *********************/
	public int getNumEdges() {

	}

	/**************
	 * Clear all edges and vertices from the graph
	 ********************/
	public void clear() {

	}
}
