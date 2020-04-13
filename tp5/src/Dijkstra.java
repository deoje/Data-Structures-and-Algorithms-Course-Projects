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

		List<Node> nodes = new ArrayList<>(graph.getNodes());

		HashMap<Node, Edge> column = new HashMap<>();
		for (Node node : nodes){
			column.put(node, new Edge(s, node, Integer.MAX_VALUE));
		}

		column.put(s, new Edge(s, s, 0));
		path.push(column.get(s));
		dijkstraTable[0] = column;

		int i = 1;
		Node current;
		while (!nodes.isEmpty()){
//			current = nodes
//					.stream()
//					.min(Comparator.comparing(Node::getLength))
//					.orElse(null);

			column = new HashMap<>(column); // Shallow copy
			current = getMinimum(column);

			nodes.remove(current);

			if (current == d)
				break;

			for (Edge adjacentEdge : graph.getEdgesGoingFrom(current)){

				Node neighbor = adjacentEdge.getDestination();

				if (!nodes.contains(neighbor))
					continue;

				int altDist = column.get(current).getDistance() + adjacentEdge.getDistance();

				if (altDist < column.get(neighbor).getDistance())
						column.put(neighbor, new Edge(current, neighbor, altDist));
						path.push(column.get(neighbor));
			}

			column.remove(current);
			dijkstraTable[i] = column;
			i++;

		}

//		Edge currentEdge = current.getPrevious();
//		if (currentEdge != null || current == s){
//			while (currentEdge != null){
//				path.push(currentEdge);
//				currentEdge = currentEdge.getSource().getPrevious();
//			}
//		}

//		List<Node> noeudsAtteints = new ArrayList<Node>(); // enregiste les noeuds intégrés
//		List<Node> noeudsNonAtteints = graph.getNodes(); // j'ai ajouté l'attribut longueur à node. à l'infini de base pour aider l'algo
//		noeudsNonAtteints.get(s.getId()).setLongueur(0);
//		noeudsAtteints.add(s);
//
//		while (!noeudsAtteints.contains(d)) {
//
//			for (Node noeudSoucre : noeudsAtteints) { //pour tous les sommets deja integrés
//				Edge meilleurChemin = new Edge();
//				int minTrajetVoisinsEnTout = 99999;
//				List<Edge> noeudsVoisins = graph.getEdgesGoingFrom(noeudSoucre);
//
//				for (Edge chemin : noeudsVoisins) { // sur tous les voisins non connus
//
//					if (!noeudsAtteints.contains(chemin.getDestination())){
//						noeudsAtteints.add(chemin.getDestination()); // on ajoute tous les nouveaux voisins
//						// on met leurs longueur à la longueur qu'il nous a fallu pour les atteindre :
//						noeudsNonAtteints.get(chemin.getDestination().getId()).setLongueur(chemin.getDistance() + noeudSoucre.getLongueur());
//						// on veut a chaque iteration savoir en plus le meilleur chemin
//						//if(noeudsNonAtteints.get(chemin.getDestination().getId()).getLongueur() < minTrajetVoisinsEnTout) {
//						//	minTrajetVoisinsEnTout = noeudsNonAtteints.get(chemin.getDestination().getId()).getLongueur();
//						//						//	meilleurChemin = chemin;
//						dijkstraTable[noeudSoucre.getId()].put(chemin.getDestination(),chemin);
//
//					}
//				}
//				//path.push(meilleurChemin);
//			}
//		} // destination atteinte, maintenant donner le chemin precis PAS FAIT
//
//
//
//		// A compléter
//
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

		table.append("[");

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
