import java.util.Arrays;
import java.util.HashMap;
/**
 * Class for solution.
 */
public class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {
		// empty constructor
	}

	/**
	 * Main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		String caseType = StdIn.readLine();
		switch (caseType) {
		case "Score":
			String dictionaryName = StdIn.readLine();
			In in = new In("/Files/" + dictionaryName);
			String[] dictionary = in.readAllStrings();
			BoggleSolver solver = new BoggleSolver(dictionary);

			String boardName = StdIn.readLine();
			BoggleBoard board = new BoggleBoard("/Files/" + boardName);
			int score = 0;
			HashMap<String, Integer> entry = solver.getAllValidWords(board);
			for (String variableName : entry.keySet())
				score += solver.scoreOf(variableName);
          
    		/*for(int i=0;i<entry.size();i++)
    			score += solver.scoreOf();
    		
    		*/
			/*for (String word : solver.getAllValidWords(board)) {
				score += solver.scoreOf(word);
			}*/
			StdOut.println("Score = " + score);
			break;

		default:
			try {
				dictionaryName = StdIn.readLine();
				in = new In("/Files/" + dictionaryName);
				dictionary = in.readAllStrings();
				solver = new BoggleSolver(dictionary);
				board = null;
				if(board.equals("null")) {
					System.out.println("board is null");
					break;
				}
				score = 0;
				HashMap<String, Integer> ent = solver.getAllValidWords(board);

				for (String variableName : ent.keySet())
					score += solver.scoreOf(variableName);
					StdOut.println("Score = " + score);
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			break;
		}

	}
}