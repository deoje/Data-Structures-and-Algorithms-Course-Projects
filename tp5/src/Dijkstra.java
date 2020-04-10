import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;



public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();
		
		// A compléter

		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		return null;
	}
	

	public void showTable() {
		// A completer
		
	}

        public String printShortPath(Node source, Node destination) {
		{
		this.findPath(source,destination);
		StringBuilder chemin = new StringBuilder();
		Edge lastEdge = path.pop();

		int longeurDuChemin = lastEdge.getDistance();		
		chemin.append(lastEdge.getDestination().getName() + " ");

		while (!path.empty()){
			if (!path.empty() && path.peek().getDestination() == lastEdge.getSource()){
				chemin.append(lastEdge.getSource().getName() + " ");
				lastEdge = path.pop();
			}
			else{
				path.pop();
			}
		}
		System.out.print("La longueur du plus court chemin est : ");
		System.out.println(longeurDuChemin);
		return "Le chemin le plus court est : " + chemin.reverse().toString();


		
	}
}
