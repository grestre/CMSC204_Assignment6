
public class Town implements Comparable<Town>{
	Town templateTown;
	String name = ""; 
	
	public Town(String name) {
		this.name = name; 
	}
	public Town(Town templateTown) {
		this.templateTown = templateTown; 
	}
	@Override
	public int compareTo(Town T) {
		if(this.getName().compareToIgnoreCase(T.getName()) > 0)
			return 1;
		else if(this.getName().compareToIgnoreCase(T.getName()) < 0)
			return -1; 
		else
			return 0; 
	}

	public boolean equals(Object o) {
		boolean status; 
		if(this.getName().equalsIgnoreCase(((Town) o).getName()))
			status = true;
		else
			status = false; 
		return status; 
	}
	public int hashCode() {
		return name.hashCode(); 
	}
	public String getName() {
		return name; 
	}
	public String toString() {
		String str = "Town: " + getName(); 
		return str; 
	}
}
