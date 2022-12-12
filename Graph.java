import java.util.*;
/**
 * 
 * @author geron
 * V: Town(Vertex type)
 * E: Road(Edge type)
 */

public class Graph implements GraphInterface<Town,Road>{
	
	LinkedList<Town> townsSet;
	LinkedList<Road> roadsSet;

	public Graph() {
		townsSet = new LinkedList<Town>();
		roadsSet = new LinkedList<Road>();
	}

	  /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex){
			Road edge = null; 
			for(Road r : roadsSet) {
				if(((r.getSource().equals(sourceVertex)) && (r.getDestination().equals(destinationVertex))))
					edge = r; 
			}
			return edge; 
		}
	
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null && destinationVertex == null)
			throw new IllegalArgumentException(); 
		else {
			Road edge = new Road(sourceVertex, destinationVertex, weight, description); 
			roadsSet.add(edge); 
			return edge; 
			}
	}

	@Override
	public boolean addVertex(Town v) {
		boolean result = false; ; 
		townsSet.add(v); 
		return result; 
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		boolean found = false; 
		for(Road r : roadsSet) {
			if(r.contains(sourceVertex) && r.contains(destinationVertex))
				found = true; 
		}
		return found; 
	}

	@Override
	public boolean containsVertex(Town v) {
		boolean found = false; 
		for(Town t : townsSet) {
			if(t.getName().equals(v.getName()))
				found = true; 
		}
		return found;
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> roads = new HashSet<Road>(); 
		for(Road r : roadsSet) {
			roads.add(r);
		} 
		return roads; 
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> roads = new HashSet<Road>(); 
		for(Road r : roadsSet) {
			if(r.contains(vertex))
				roads.add(r); 
		}
		return roads;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = new Road(sourceVertex, destinationVertex, weight, description); 
		if(roadsSet.remove(road)) 
			return road; 
		return null; 
	}

	@Override
	public boolean removeVertex(Town v) {
		boolean status = false;
		if(townsSet.remove(v))
			status = true; 
		return status;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> towns = new HashSet<Town>(); 
		for(Town t : townsSet){
			towns.add(t); 
		}
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> sp = new ArrayList<String>();
		
		return sp;
	}

	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		for(Road r : roadsSet) {
			
		}
	}
	
}