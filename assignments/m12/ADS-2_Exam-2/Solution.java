import java.util.Scanner;
import java.util.ArrayList;
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
		DijkstraUndirectedSP d;
		DijkstraUndirectedSP v;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(graph);
			break;

		case "DirectedPaths":
			// Handle the case of Directedpaths, where two integers are given.
			// First is the source and second is the destination.
			// If the pathVia exists print the distance between them.
			// Other wise print "No path Found."
			int source = scan.nextInt();
			int destination = scan.nextInt();
			d = new DijkstraUndirectedSP(graph, source);
			if ((d.distTo(destination)) == Double.POSITIVE_INFINITY) {
				System.out.println("No Path Found.");
			} else {
				System.out.println(d.distTo(destination));
			}
			break;
		case "ViaPaths":
			// Handle the case of Viapaths, where three integers are given.
			// First is the source and second is the via is the one where pathVia should pass throuh.
			// third is the destination.
			// If the pathVia exists print the distance between them.
			// Other wise print "No pathVia Found."
			source =scan.nextInt();
			int via= scan.nextInt();
			destination= scan.nextInt();
			d = new DijkstraUndirectedSP(graph, source);
			v= new DijkstraUndirectedSP(graph, via);
			if((d.distTo(via)) == Double.POSITIVE_INFINITY || (v.distTo(destination)) == Double.POSITIVE_INFINITY) {
				System.out.println("No Path Found.");
			} else {

				System.out.println(d.distTo(via)+v.distTo(destination));
				ArrayList<Integer> pathVia = new ArrayList<>();
				pathVia.add(source);
                for (Edge e : d.pathTo(via)) {
                    int tem = e.either();
                    if (!pathVia.contains(tem)) {
                        pathVia.add(tem);
                    }
                    if (!pathVia.contains(e.other(tem))) {
                        pathVia.add(e.other(tem));
                }
                for (Edge a : v.pathTo(destination)) {
                    int temp = a.either();
                    if (!pathVia.contains(temp)) {
                    	pathVia.add(temp);
                    }
                    if (!pathVia.contains(a.other(temp))) {
                        pathVia.add(a.other(temp));
                    }
                }
				String out = pathVia.toString().replaceAll(",", "");
                out = out.substring(1, out.length() - 1);
                System.out.println(out);
			}
		}
			break;

		default:
			break;
		}

	}
}