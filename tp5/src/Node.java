public class Node {

	private int id;
	private String name;
	private int length;
	private Edge previous;
		
	public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.length = Integer.MAX_VALUE;
		this.previous = null;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
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
