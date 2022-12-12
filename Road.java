
public class Road implements Comparable<Road>{
	Town source = null; 
	Town destination = null; 	
	int weight = 0; 
	String name = ""; 
	

	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination; 
		this.weight = weight; 
		this.name = name; 
	}
	/**
	 * 
	 * @param source
	 * @param destination
	 * @param name
	 */
	public Road(Town source, Town destination, String name) {
		this.weight = 1; 
	}
	@Override
	public int compareTo(Road r) {	
		if(this.getName().compareToIgnoreCase(r.getName()) > 0)
			return 1;
		else if(this.getName().compareToIgnoreCase(r.getName()) < 0)
			return -1; 
		else
			return 0; 
	}
	boolean contains(Object town) {
		boolean status; 
		if(source.compareTo((Town) town) == 0 || destination.compareTo((Town) town) == 0)
			status = true; 
		else
			status = false; 
		return status; 
	}
	public boolean equals(Object r) {
		boolean status = false; 
		if(((Road) r).getDestination().equals(((Road) r).getDestination()))
			status = true; 
		return status; 
	}
	
	Town getDestination() {
		return destination; 
	}
	String getName() {
		return name; 
	}
	Town getSource() {
		return source; 
	}
	int getWeight() {
		return weight; 
	}
	
	void setDestination(Town destination) {
		this.destination = destination; 
	}
	void setName(String name) {
		this.name = name; 
	}
	void setSource(Town source) {
		this.source = source; 
	}
	void setWeight(int weight) {
		this.weight = weight; 
	}
	public String toString() {
		String str = "" + getName(); 
		return str; 
	}
	
}
