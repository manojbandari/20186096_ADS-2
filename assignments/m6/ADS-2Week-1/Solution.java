import java.util.Scanner;
class PageRank {
	Digraph d;
	double[] pageRank;
	PageRank(Digraph d) {
		this.d = d;
		pageRank = new double[d.V()];
		for (int i = 0; i < pageRank.length; i++) {
			pageRank[i] = 1.0 / d.V();
		}
	}
	double getPR(int v) {
		double p = pageRank[v];
		//double finalpageRank=0;
		for(int i = 0; i < 1000; i++) {
			for(int j=0; j<d.V();j++)
				for (int a: d.adj(j)) {
					if(d.outdegree(a)==0) {
						return 0;
					}
					p = pageRank[a]/d.outdegree(a);
					//finalpageRank+=p;
				}
			}
		return p;
	}
	public String toString() {
		String str = "";
		str += d + "\n";
		for (int i = 0; i < d.V(); i++) {
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
		// and build the graph
		Digraph d = new Digraph(vertices);
		for (int i = 0; i <= vertices; i++) {
			String[] s=scan.nextLine().split(" ");
			for(int j=1;j<s.length;j++) {
				d.addEdge(Integer.parseInt(s[0]),Integer.parseInt(s[j]));
			}
		}

		//System.out.pageRankintln(d);
		// Create page rank object and pass the graph ``object to the constructor
		PageRank p= new PageRank(d);
		// pageRankint the page rank object
		System.out.println(p);
		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";
		WebSearch w = new WebSearch(p,file);
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		// read the search queries from std in
		// remove the q= pageRankefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// pageRankint the return value of iAmFeelingLucky
		//System.out.pageRankintln(w.iAmFeelingLucky());
	}
}
