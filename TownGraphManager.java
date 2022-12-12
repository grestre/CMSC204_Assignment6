import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface{

 
	LinkedList<Town> towns; 
	LinkedList<Road> roads;
	Town previous; 
	public TownGraphManager() {
		towns = new LinkedList<Town>(); 
		roads = new LinkedList<Road>(); 
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = new Town(town1); 
		Town destination = new Town(town2); 
		Road newRoad = new Road(source, destination, weight, roadName); 
		roads.add(newRoad); 
		return true;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */	 
	@Override
	public String getRoad(String town1, String town2) {
		String road = ""; 
		for(Road r : roads) {
			if((r.getSource().getName().equals(town1)) && (r.getDestination().getName().equals(town2)))
				road += r.getName(); 
		}
		return road; 
	}
	
	@Override
	public boolean addTown(String v) {
		Town newTown = new Town(v); 
		towns.add(newTown); 
		return true;
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town source = null; 
		for(int a = 0; a < towns.size(); a++) {
			if(towns.get(a).getName().equals(name))
				source = towns.get(a); 
		}
		return source;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		boolean status = false; 
		for(Town t : towns) {
			if(t.getName().equals(v))
				status = true; 
		}
		return status;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Boolean status = null; 
		Town sourceTown = null; 
		Town destinationTown = null; 
		for(int a = 0; a < towns.size(); a++) {
			if(towns.get(a).getName().equals(town1))
				sourceTown = towns.get(a); 
			else if(towns.get(a).getName().equals(town2))
				destinationTown = towns.get(a); 
		}
		for(Road r : roads) {
			if(r.contains(sourceTown) && r.contains(destinationTown))
				status = true; 
			else
				status = false; 
		}
		return status;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList roadList = new ArrayList<String>(); 
		for(Road r : roads)
			roadList.add(r.getName()); 
		Collections.sort(roadList); 
		return roadList;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Boolean status = null; 
		Town sourceTown = null; 
		Town destinationTown = null; 
		for(int a = 0; a < towns.size(); a++) {
			if(towns.get(a).getName().equals(town1))
				sourceTown = towns.get(a); 
			else if(towns.get(a).getName().equals(town2))
				destinationTown = towns.get(a); 
		}
		Road deleteRoad = new Road(sourceTown, destinationTown, road); 
		roads.remove(deleteRoad); 
		for(Road r : roads) {
			if(r.contains(sourceTown) && r.contains(destinationTown))
				status = false;
			else
				status = true; 
		}
		return status; 
	}

	@Override
	public boolean deleteTown(String v) {
		Town newTown = new Town(v); 
		Boolean status = false; 
		towns.remove(newTown); 
			status = true; 
		return status; 
	}
	
	@Override
	public ArrayList<String> allTowns() {
		ArrayList townList = new ArrayList<String>(); 
		for(Town t : towns) {
			townList.add(t.getName());
			Collections.sort(townList); 
		}
		return townList;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		ArrayList<String> path = new ArrayList<>(); 
		Town sourceTown = null; 
		Town destinationTown = null; 
		for(int a = 0; a < towns.size(); a++) {
			if(towns.get(a).getName().equals(town1))
				sourceTown = towns.get(a); 
			else if(towns.get(a).getName().equals(town2))
				destinationTown = towns.get(a); 
		}
		for(Road r : roads)
			path.add(r.getName()); 
		Collections.reverse(path); 
		return path;
	}
	
}
