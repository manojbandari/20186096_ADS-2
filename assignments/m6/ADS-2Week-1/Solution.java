import java.util.Scanner;
class PageRank {
	Double[] pagerank;
	Digraph d;
	Digraph rev;
	PageRank(Digraph g) {
		this.d = g;
		pagerank = new Double[g.V()];
		rev = d.reverse();
		cal();
	}
	public void cal() {
		Double pr = 0.0;
		for (int i = 0; i < d.V(); i++) {
			if (d.indegree(i) == 0) {
				pagerank[i] = 0.0;
			} else {
				pagerank[i] = 1 / (double)d.V();
			}
		}
		double[] a = new double[d.V()];
		for ( int j = 0; j < 1000; j++) {
			for ( int i = 0; i < d.V(); i++) {
				pr = 0.0000;
				for (int each : rev.adj(i)) {
					pr += ((double)pagerank[each] / (double)d.outdegree(each));
				}
				a[i] = pr;
			}
			for (int i = 0; i < d.V(); i++) {
				pagerank[i] = a[i];
			}
		}
	}
	double getPR(int v) {
		return pagerank[v];
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < pagerank.length; i++) {
			str += i + " - " + getPR(i) + "\n";
		}
		return str;
	}
}


class WebSearch {
	WebSearch(PageRank p, String f) {

	}
	int iAmFeelingLucky() {
		return 0;
	}
}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();

		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the Digraph
		Digraph d = new Digraph(vertices);
		for (int i = 0; i <= vertices; i++) {
			String[] s = scan.nextLine().split(" ");
			for (int j = 1; j < s.length; j++) {
				d.addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[j]));
			}
		}

		System.out.println(d);
		for (int i = 0; i < vertices; i++) {
			if (d.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					if (i != j) {
						d.addEdge(i, j);
					}
				}
			}

		}

		// Create page rank object and pass the Digraph ``object to the constructor
		PageRank p = new PageRank(d);
		// pageRankint the page rank object
		System.out.println(p);
		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";
		WebSearch w = new WebSearch(p, file);
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		// read the search queries from std in
		// remove the q= pageRankefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// pageRankint the return value of iAmFeelingLucky
		//System.out.pageRankintln(w.iAmFeelingLucky());
	}
}
