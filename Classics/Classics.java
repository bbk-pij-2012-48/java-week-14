public class Classics {
	private int[] precalculated = null;
	
	private void init(int n) {
		precalculated = new int[n];
		for(int i=0 ; i<n ; i++){
			precalculated[i] = -1;
		}
		precalculated[0] = 1;
		precalculated[1] = 1;		
	}
	
	public int fibonacciMemory(int n){
		if(precalculated == null) {
			init(n);
		}
		if(precalculated[n-1] != -1) {
			return precalculated[n-1];
		}
		int result = fibonacciMemory(n-1) + fibonacciMemory(n-2);
		precalculated[n-1] = result;
		return result;
	}
	

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
	
	public static int fibonacci(int n) {
		if(n == 1 || n==2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int iterativeFibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		int tmp = 1;
		int tmp2 = 1;
		int tmp3;
		for(int i=0 ; i<n-2 ; i++) {
			tmp3 = tmp + tmp2;
			tmp = tmp2;
			tmp2 = tmp3;
		}
		return tmp2;
	}
	
	public static void main(String[] args) {
		long finish;
		long start = System.nanoTime();
		System.out.println(iterativeFibonacci(45));
		finish = System.nanoTime();
		System.out.println("With iterative methods, took " + (finish - start));	

		start = System.nanoTime();
		System.out.println(fibonacci(45));
		finish = System.nanoTime();
		System.out.println("Without memory, took " + (finish - start));	
		Classics launch = new Classics();
		launch.launcher();
	}
	
	public void launcher() {
		long finish;
		long start = System.nanoTime();
		System.out.println(fibonacciMemory(45));
		finish = System.nanoTime();
		System.out.println("With memory, took " + (finish - start));
	}

	
}
