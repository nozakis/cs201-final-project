import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Graph<T> implements BasicGraphADT<T> {

	private HashMap<Integer,Vertex<T>> vertMap;

	public Graph() {
		this.vertMap = new HashMap<Integer,Vertex<T>>();
	}

	/*******************
	 * Add a vertex to this graph with given label
	 * @return Whether the vertex was successfully added
	 ********************/
	public boolean addVertex(T vert) {
		Vertex<T> v = new Vertex<T>(vert);
		this.vertMap.put(v.hashCode(), v);
		return true;
	}

	/******************
	 * Add an edge to this graph between the two given labels
	 * @return Whether the edge was successfully added
	 ********************/
	public boolean addEdge(T beg, T end) {
		List<Vertex<T>> vertList = (List<Vertex<T>>) vertMap.values();
		List<T> lbList = new ArrayList<T>();
		for(int i = 0; i < vertList.size(); i++) {
			lbList.add(vertList.get(i).getLabel());
		}
		
		if(!lbList.contains(beg) || !lbList.contains(end)) {
			return false;
		} else {
			int begI = lbList.indexOf(beg);
			int endI = lbList.indexOf(end);
			vertList.get(begI).addNeighbor(vertList.get(endI));
			vertList.get(endI).addNeighbor(vertList.get(begI));
			return true;
		}
	}

	/******************
	 * Tests whether a vertex exists in the graph
	 * @return Whether the vertex exists
	 ********************/
	public boolean hasVertex(T vert) {
		List<Vertex<T>> vertList = (List<Vertex<T>>) vertMap.values();
		List<T> lbList = new ArrayList<T>();
		
		for(int i = 0; i < vertList.size(); i++) {
			lbList.add(vertList.get(i).getLabel());
		}
		
		if(lbList.contains(vert)) {
			return true;
		}
		
		return false;
	}


	/******************
	 * Tests whether an edge exists in the graph
	 * @return Whether the edge exists
	 ********************/
	public boolean hasEdge(T beg, T end) {
		List<Vertex<T>> vertList = (List<Vertex<T>>) vertMap.values();
		List<T> lbList = new ArrayList<T>();
		for(int i = 0; i < vertList.size(); i++) {
			lbList.add(vertList.get(i).getLabel());
		}
		
		if(!lbList.contains(beg) || !lbList.contains(end)) {
			return false;
		} else {
			int begI = lbList.indexOf(beg);
			int endI = lbList.indexOf(end);
			List<Vertex<T>> begNeighbors = vertList.get(begI).getNeighbors();
			List<Vertex<T>> endNeighbors = vertList.get(endI).getNeighbors();
			if(!begNeighbors.contains(vertList.get(endI)) || !endNeighbors.contains(vertList.get(begI))) {
				return false;
			} else {
				return true;
			}
		}
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
