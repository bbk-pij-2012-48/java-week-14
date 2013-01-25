public class McCarthy {
	public int mcCarthy91(int n) {
		if (n > 100) {
			return n - 10;
		} else {
			return mcCarthy91(mcCarthy91(n+11));
		}
	}
	
	public static void main(String[] args) {
		McCarthy launcher = new McCarthy();
		launcher.launch();
	}
	
	public void launch() {
		System.out.println(mcCarthy91(-1));
		System.out.println(mcCarthy91(91));
		System.out.println(mcCarthy91(200));
	}
}
