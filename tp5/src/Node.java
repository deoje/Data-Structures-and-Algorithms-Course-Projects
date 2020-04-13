import java.util.LinkedList;
import java.util.List;

public class Node {

	private int id;
	private String name;
	private int distance;
	private Edge previous;
		
	public Node(int id, String n) {
		this.id = id;
		name = n;
		distance = Integer.MAX_VALUE;
		previous = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Edge getPrevious() {
		return previous;
	}

	public void setPrevious(Edge previous) {
		this.previous = previous;
	}

	@Override
	public int hashCode() {
		return id;
	}


}
