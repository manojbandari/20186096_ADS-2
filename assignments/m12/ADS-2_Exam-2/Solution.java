import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		scan.nextLine();
		EdgeWeightedGraph graph = new EdgeWeightedGraph(vertices);
		for(int i=0;i<edges;i++) {
			String[] directions= scan.nextLine().split(" ");
			graph.addEdge(new Edge(Integer.parseInt(directions[0]), Integer.parseInt(directions[1]), Double.parseDouble(directions[2])));
		}
		String caseToGo = scan.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(graph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			if(true) {

			}
			else {
				System.out.println("No Path Found.");
			}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}