import java.lang.reflect.Array;
import java.util.*;


public class Dijkstra {

	private Graph graph;
	private HashMap<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;


	public Dijkstra (Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<>();

		List<Node> nodes = graph.getNodes();

		for (Node node : nodes){
			node.setDistance(Integer.MAX_VALUE);
			node.setPrevious(null);
		}

		s.setDistance(0);

		int i = 0;
		Node current = s;
		dijkstraTable[i].put(current, null);
		while (!nodes.isEmpty()){
			i++;
			current = nodes
					.stream()
					.min(Comparator.comparing(Node::getDistance))
					.orElse(null);

			nodes.remove(current);

			if (current == d)
				break;
			for (Edge adjacentEdge : graph.getEdgesGoingFrom(current)){
				Node neighbor = adjacentEdge.getDestination();
				if (!nodes.contains(neighbor))
					continue;
				int altDist = current.getDistance() + adjacentEdge.getDistance();
				if (altDist < neighbor.getDistance()){
						neighbor.setDistance(altDist);
						neighbor.setPrevious(adjacentEdge);
						dijkstraTable[i].put(current, adjacentEdge);
				}
			}
		}
		Edge currentEdge = current.getPrevious();
		if (currentEdge != null || current == s){
			while (current != null){
				path.push(current.getPrevious());
				current = current.getPrevious().getDestination();
			}
		}

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
//		// A completer FAIT
//		if(e1.getDistance()>=e2.getDistance()){
//			return e1;
//		}
//		return e2;
		return null;
	}


	public void showTable() {
		// A completer
//		return;
	}}
/*
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
*/