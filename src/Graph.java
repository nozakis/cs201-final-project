import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Graph<T> implements BasicGraphADT<T> {

	private HashMap<Integer,Vertex<T>> vertMap;
	private List<T> lbList;
	private int edgeCount;

	public Graph() {
		this.vertMap = new HashMap<Integer,Vertex<T>>();
		this.lbList = new ArrayList<T>();
		this.edgeCount = 0;
	}

	/*******************
	 * Add a vertex to this graph with given label
	 * @return Whether the vertex was successfully added
	 ********************/
	public boolean addVertex(T vert) {
		Vertex<T> v = new Vertex<T>(vert);
		this.vertMap.put(v.hashCode(), v);
		this.lbList.add(vert);
		return true;
	}

	/******************
	 * Add an edge to this graph between the two given labels
	 * @return Whether the edge was successfully added
	 ********************/
	public boolean addEdge(T beg, T end) {
		List<Vertex<T>> vertList = new ArrayList<Vertex<T>>(vertMap.values());
		
		if(this.vertMap.containsKey(beg.hashCode()) && this.vertMap.containsKey(end.hashCode())) {
			int begI = this.lbList.indexOf(beg);
			int endI = this.lbList.indexOf(end);
			vertList.get(begI).addNeighbor(vertList.get(endI));
			vertList.get(endI).addNeighbor(vertList.get(begI));
			this.edgeCount++;
			return true;
		}
		
		return false;
	}

	/******************
	 * Tests whether a vertex exists in the graph
	 * @return Whether the vertex exists
	 ********************/
	public boolean hasVertex(T vert) {
		if(this.lbList.contains(vert)) {
			return true;
		}
		
		return false;
	}


	/******************
	 * Tests whether an edge exists in the graph
	 * @return Whether the edge exists
	 ********************/
	public boolean hasEdge(T beg, T end) {
		List<Vertex<T>> begNeighbors = getNeighbors(beg);
		
		return begNeighbors.contains(getVertex(end));
	}


	/*****************
	 * Gets a list containing all the neighbors of a given vertex
	 * @return the neighbor list as a java List
	 *********************/
	public List<Vertex<T>> getNeighbors(T vert) {
		List<Vertex<T>> vertList = new ArrayList<Vertex<T>>(vertMap.values());

		return vertList.get(this.lbList.indexOf(vert)).getNeighbors();
	}

	/****************************
	 * Gets the vertex object associated with the given label
	 * @return the vertex
	 ************************/
	public Vertex<T> getVertex(T lab) {
		return this.vertMap.get(lab.hashCode());
	}

	/*****************
	 * Tests if the graph is empty
	 * @return Whether the graph is empty
	 *******************/
	public boolean isEmpty() {
		return this.vertMap.isEmpty();
	}

	/********************
	 * Gets the number of vertices
	 * @return The number of vertices
	 *******************/
	public int getNumVertices() {
		return this.vertMap.size();
	}

	/********************
	 * Gets the number of edges
	 * @return The number of edges
	 *********************/
	public int getNumEdges() {
		return this.edgeCount;
	}

	/**************
	 * Clear all edges and vertices from the graph
	 ********************/
	public void clear() {
		this.vertMap = new HashMap<Integer,Vertex<T>>();
		this.lbList = new ArrayList<T>();
		this.edgeCount = 0;
	}
	
	public void print() {
		for(int i = 0; i < lbList.size(); i++) {
			System.out.println(lbList.get(i));
		}
	}
	
	public static void main(String[] args) {
		Graph<String> g = new Graph<String>();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		System.out.println("true: " + g.addEdge("a", "e"));
		System.out.println("true: " + g.addEdge("a", "c"));
		System.out.println("true: " + g.addEdge("e", "d"));
		System.out.println("true: " + g.addEdge("b", "c"));
		System.out.println("true: " + g.addEdge("b", "d"));
		System.out.println("true: " + g.addEdge("c", "d"));
		System.out.println("true: " + g.hasVertex("c")); //true
		System.out.println("false: " + g.hasVertex("1")); //false
		System.out.println("true: " + g.hasVertex("b")); //true
		System.out.println("false: " + g.hasEdge("e", "b")); //false
		System.out.println("true: " + g.hasEdge("a", "e")); //true
		System.out.println("5: " + g.getNumVertices()); //5
		System.out.println("6: " + g.getNumEdges()); //6
		
	}
}
