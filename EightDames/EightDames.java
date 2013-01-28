public class EightDames {
	private boolean[][] board;
	
	private void init(int n) {
		board = new boolean[n][n];
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				board[i][j] = true;
			}
		}
	}
	
	private void prettyPrint() {
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(board[i][j]) {
					System.out.print("o\t");
				}
				else {
					System.out.print("X\t");
				}
			System.out.println();
			}
		}
	}
				
