import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class TowersOfHanoi {
	private List<int[]> move = new LinkedList<>();
	
	/**
	* Moves #'blocks' blocks from 'src' to 'dst', where these are ints from {0,1,2}
	*/
	private void move(int blocks, int src, int dst) {
		if(blocks == 1) {
			move.add(new int[] {src, dst});
		} else {
			move(blocks-1, src, not(src, dst)); // move the top n-1 blocks to the free pole
			move.add(new int[] {src,dst}); // move the bottom block where you want it
			move(blocks-1 , not(src, dst), dst); // move the pile of n-1 blocks back to dst
		}
	}
	
	private void solve(int blocks) {
		move(blocks, 0, 2);
	}	

	private int not(int a, int b) {
		for(int i=0 ; i<=2 ; i++) {
			if(i!=a && i!=b) {
				return i;
			}
		}
		return -1; // fussy compiler
	}
	
	private void prettyPrint() {
		Iterator itr = move.listIterator();
		while(itr.hasNext()) {
			int[] tmp = (int[])itr.next();
			System.out.println("Move block from pole " + (tmp[0] + 1) + " to pole " + (tmp[1] + 1));
		}
	}
	
	public static void main(String[] args) {
		TowersOfHanoi launcher = new TowersOfHanoi();
		launcher.launch();
	}
	
	public void launch() {
		solve(Integer.parseInt(System.console().readLine()));
		prettyPrint();
	}
	
}
