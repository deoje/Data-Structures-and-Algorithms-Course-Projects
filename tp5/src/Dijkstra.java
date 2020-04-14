import java.security.Key;
import java.util.*;


public class Dijkstra {

	private Graph graph;
	private HashMap<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;


	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {

		if (graph == null)
			return;

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<>();

		ArrayList<Node> visitedNodes = new ArrayList<>();
		Map<Node, Edge> column = new HashMap<>();
		Node neighbor;
		int altDist;
		int currentDist;
		int uv;

		for (Node node : graph.getNodes()){
			column.put(node, new Edge(s, node, Integer.MAX_VALUE));
		}

		column.put(s, new Edge(s, s, 0));
		path.push(column.get(s));

		int i = 0; // counter for Dijkstra iterations
		Node current; // u
		while (!visitedNodes.contains(d)){

			dijkstraTable[i++] = (HashMap<Node, Edge>) column;
			column = new HashMap<>(column);

			current = getMinimum(column);
			currentDist = column.get(current).getDistance();

			visitedNodes.add(current);
			column.remove(current);

			for( Edge neighborEdge : graph.getEdgesGoingFrom(current) ){

				neighbor = neighborEdge.getDestination();
				uv = neighborEdge.getDistance();
				altDist = currentDist + uv;

				if( visitedNodes.contains(neighbor) )
					continue;

				if( column.get(neighbor).getDistance() > altDist){
					column.put(neighbor,
							new Edge(current,
									neighborEdge.getDestination(),
									altDist)
					);
					path.push(column.get(neighbor));
				}
			}
		}
		while (path.peek().getDestination() != d){
			path.pop();
		}
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

		if (e1 == null || e2 == null)
			return null;

		if( e1.getDistance() >= e2.getDistance() ){
			return e2;
		}
		return e1;
	}

	public void showTable() {

		if (dijkstraTable == null || graph == null)
			return;

		Node node;

		StringBuilder table = new StringBuilder();

		table.append("\n[");

		List<Node> nodes = graph.getNodes();
		for (int i = 0; i < nodes.size(); i++){
			table.append(nodes.get(i).getName());
			if (i == nodes.size() - 1)
				table.append("     ");
			else
				table.append("      , ");
		}
		table.append("]\n");
		for (HashMap<Node, Edge> map : dijkstraTable) {
			// if looking for close vertices
			// dijkstraMap will not be full
			if( map == null)
				continue;

			table.append("[");

			for (int i = 0; i < nodes.size(); i++){
				node = nodes.get(i);
				if (map.containsKey(node) &&
						map.get(node).getDistance() != Integer.MAX_VALUE)
					table.append(map.get(node).getDistance())
							.append(map.get(node).getSource().getName());
				else
					table.append("  ");

				if (i == nodes.size() - 1)
					table.append("    ");
				else
					table.append("     , ");
			}

			table.append("]\n");

		}
		System.out.println(table);
	}

	public String printShortPath(Node source, Node destination) {
		this.findPath(source,destination);

		if (path == null)
			return "";

		StringBuilder chemin = new StringBuilder();
		Edge lastEdge = path.pop();

		int longeurDuChemin = lastEdge.getDistance();
		chemin.append(lastEdge.getDestination().getName()).append(" ");

		while (!path.empty()){
			if (!path.empty() && path.peek().getDestination() == lastEdge.getSource()){
				chemin.append(lastEdge.getSource().getName()).append(" ");
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
