public class EightDames {
		
	private boolean[][] init() {
		boolean[][] board = new boolean[8][8];
		for(int i=0 ; i<8 ; i++) {
			for(int j=0 ; j<8 ; j++) {
				board[i][j] = true;
			}
		}
		return board;
	}
	
	private void prettyPrint(boolean[][] board) {
		System.out.println();
		for(int i=0 ; i<8 ; i++) {
			for(int j=0 ; j<8 ; j++) {
				if(board[i][j]) {
					System.out.print("O ");
				}
				else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}
	
	private int min(int a, int b) {
		if(a < b) {
			return a;
		}
		
		return b;
	}
	
	private void colour(boolean[][] board, int r, int c) {
		for(int i=0 ; i<8 ; i++) {
			board[i][c] = false;	// colour the whole column
			board[r][i] = false;	// colour the whole row
			if(r - min(r,c) + i < 8 && c - min(r,c) + i < 8) {
				board[r - min(r,c) + i][c - min(r,c) + i] = false; // colour top-left to bottom-right diagonal
			}
			
			if(c + r - i < 8 && c+ r - i >= 0) {	// colour top-right to bottom-left diagonal
				if (r == min(r,c)) {
					board[i][c + r - i] = false;
				} else {
					board[c + r - i][i] = false;
				}
			}
			board[r][c] = true;	// uncolour the chosen position (will not be used again since this row is taken now)
		}
	}
	
	private boolean[][] cloneBoard(boolean[][] board) {
		boolean[][] board2 = new boolean[8][];
		for(int i=0 ; i<8 ; i++) {
			board2[i] = board[i].clone();
		}
		return board2;
	}
	
	private boolean[][] solve(boolean[][] board, int n) {
		boolean[][] board2 = cloneBoard(board); // Save a copy of the board
		if(n == 8) {
			return board;			// All queens have been placed successfully
		}
		for (int i=0 ; i<8 ; i++) {
			if(board[n][i]) {
				colour(board, n, i);
				boolean[][] tmp = solve(board, n+1);
				if(tmp != null) {
					return tmp;
				}
				board = cloneBoard(board2);	// Restore the original board at this level, and try again
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		EightDames launcher = new EightDames();
		launcher.launch();
	}
	
	public void launch() {
		boolean[][] board = init();
		boolean[][] solution = solve(board, 0);
		if(solution == null) {
			System.out.println("No solution found :(");
			return;
		}
		prettyPrint(solution);
	}
}
			

