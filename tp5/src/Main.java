import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1
		Node A = new Node(0,"A");
		Node B = new Node(1,"B");
		Node C = new Node(2,"C");
		Node D = new Node(3,"D");
		Node E = new Node(4,"E");
		Node F = new Node(5,"F");
		Node G = new Node(6,"G");
		Edge arcAB = new Edge(A,B,2);
		Edge arcAC = new Edge(A,C,1);
		Edge arcBA = new Edge(B,A,2);
		Edge arcBC = new Edge(B,C,2);
		Edge arcBD = new Edge(B,D,1);
		Edge arcBE = new Edge(B,E,3);
		Edge arcCA = new Edge(C,A,1);
		Edge arcCB = new Edge(C,B,2);
		Edge arcCD = new Edge(C,D,4);
		Edge arcCE = new Edge(C,E,3);
		Edge arcCF = new Edge(C,F,5);
		Edge arcDB = new Edge(D,B,1);
		Edge arcDC = new Edge(D,C,4);
		Edge arcDF = new Edge(D,F,6);
		Edge arcDG = new Edge(D,G,5);
		Edge arcEB = new Edge(E,B,3);
		Edge arcEC = new Edge(E,C,3);
		Edge arcEF = new Edge(E,F,1);
		Edge arcFC = new Edge(F,C,5);
		Edge arcFD = new Edge(F,D,6);
		Edge arcFE = new Edge(F,E,1);
		Edge arcFG = new Edge(F,G,2);
		Edge arcGD = new Edge(G,D,5);
		Edge arcGF = new Edge(G,F,2);
		List<Edge> listeArcs= new ArrayList<Edge>();
		listeArcs.add(arcAB);
		listeArcs.add(arcAC);
		listeArcs.add(arcBA);
		listeArcs.add(arcBC);
		listeArcs.add(arcBD);
		listeArcs.add(arcBE);
		listeArcs.add(arcCA);
		listeArcs.add(arcCB);
		listeArcs.add(arcCD);
		listeArcs.add(arcCE);
		listeArcs.add(arcCF);
		listeArcs.add(arcDB);
		listeArcs.add(arcDC);
		listeArcs.add(arcDF);
		listeArcs.add(arcDG);
		listeArcs.add(arcEB);
		listeArcs.add(arcEC);
		listeArcs.add(arcEF);
		listeArcs.add(arcFC);
		listeArcs.add(arcFD);
		listeArcs.add(arcFE);
		listeArcs.add(arcFG);
		listeArcs.add(arcGD);
		listeArcs.add(arcGF);
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

		/*Should print out two list with same length*/
//		System.out.println(g.getEdgesGoingFrom(C));
//		System.out.println(g.getEdgesGoingTo(C));

//
//		// Partie 2:
//
//		Dijkstra d = new Dijkstra(g);
//
//		d.findPath(A, G/* Spécifiez les paramètres */);
//
//		d.showTable();
//
//		// Affichage le chemin le plus court :
//		//System.out.println(d.printShortPath(null, null/* Spécifiez les paramètres */));
//
	}
}
