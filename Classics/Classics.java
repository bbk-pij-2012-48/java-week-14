public class Classics {

	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static int iterativeFactorial(int n) {
		int tmp = 1;
		for(int i=1 ; i<=n ; i++) {
			tmp *= i;
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(iterativeFactorial(5));
	}

	
}
