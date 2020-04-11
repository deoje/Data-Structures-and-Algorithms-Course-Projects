

public class Node {

	private int id;
	private int longueur;
	private String name;
		
        public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.longueur = 9999;
	}
		
	public int getId() {
		return id;
	}

	public int getLongueur() {
		return longueur;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	public int hashCode() {
		return id;
	}

	
	
}
