import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe FAIT
		Node A = new Node(0,"A");
		Node B = new Node(1,"B");
		Node C = new Node(2,"C");
		Node D = new Node(3,"D");
		Node E = new Node(4,"E");
		Node F = new Node(5,"F");
		Node G = new Node(6,"G");
		Edge arcAB = new Edge(A,B,2);
		Edge arcAC = new Edge(A,C,1);
		Edge arcBC = new Edge(B,C,2);
		Edge arcBD = new Edge(B,D,1);
		Edge arcBE = new Edge(B,E,3);
		Edge arcCD = new Edge(C,D,4);
		Edge arcCF = new Edge(C,F,5);
		Edge arcCE = new Edge(C,E,2);
		Edge arcDG = new Edge(D,G,5);
		Edge arcDF = new Edge(D,F,6);
		Edge arcEF = new Edge(E,F,1);
		Edge arcFG = new Edge(F,G,2);
		List<Edge> listeArcs= new ArrayList<Edge>();
		listeArcs.add(arcAB);
		listeArcs.add(arcAC);
		listeArcs.add(arcBD);
		listeArcs.add(arcBE);
		listeArcs.add(arcCD);
		listeArcs.add(arcCF);
		listeArcs.add(arcCE);
		listeArcs.add(arcDG);
		listeArcs.add(arcDF);
		listeArcs.add(arcEF);
		listeArcs.add(arcFG);
		g.setEdges(listeArcs);
		List<Node> listeNoeuds= new ArrayList<Node>();
		listeNoeuds.add(A);
		listeNoeuds.add(B);
		listeNoeuds.add(G);
		listeNoeuds.add(C);
		listeNoeuds.add(D);
		listeNoeuds.add(E);
		listeNoeuds.add(F);
		g.setNodes(listeNoeuds);

		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(A, G/* Spécifiez les paramètres */);
		
		d.showTable();

		// Affichage le chemin le plus court :
		//System.out.println(d.printShortPath(null, null/* Spécifiez les paramètres */));
	
	}
}
