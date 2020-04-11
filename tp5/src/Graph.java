import java.util.ArrayList;
import java.util.List;



public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter FAIT
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complèter FAIT
		List<Edge> edgesToSource = new ArrayList<Edge>();
		for (Edge edgesT : edges) {
			if (edgesT.getSource() == source){
				edgesToSource.add(edgesT);
			}
		}
		return edgesToSource;
		
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complèter FAIT
		List<Edge> edgesToDestination = new ArrayList<Edge>();
		for (Edge edgesT : edges) {
			if (edgesT.getDestination() == dest){
				edgesToDestination.add(edgesT);
			}
		}
		return edgesToDestination;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
