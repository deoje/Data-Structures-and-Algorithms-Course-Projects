import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class Graph {

	private List<Node> nodes; // Nodes
	private List<Edge> edges; // Edges
	
	public Graph() {

		nodes = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {

		List<Edge> edgesToSource = new ArrayList<>();

		for (Edge edge : edges) {
			if (edge.getSource() == source){
				edgesToSource.add(edge);
			}
		}
		return edgesToSource;
	}

	public List<Edge> getEdgesGoingTo(Node dest) {

		List<Edge> edgesToDestination = new ArrayList<>();

		for (Edge edge : edges) {
			if (edge.getDestination() == dest){
				edgesToDestination.add(edge);
			}
		}
		return edgesToDestination;
	}
	
	// Accessors
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
