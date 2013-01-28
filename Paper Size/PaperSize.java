public class PaperSize {
	
	public static void size(String name) {
		int[] output = new int[2];
		if(name.charAt(1) == '0') {
			output = size(name.length() - 2);
			System.out.println(output[0] + "mm x " + output[1] + "mm");
			return;
		}
		output = size(-1 * Integer.parseInt(name.substring(1)));
		System.out.println(output[0] + "mm x " + output[1] + "mm");
		return;
	}
		
		
	private static int[] size(int n) {
		if(n == 0) {
			return new int[] {841, 1189}; // i.e. A0
		}
		if(n > 0) { 
			return doubleIt(size(n-1));   // n=1 is A00, n=5 is A000000
		}
		return halfIt(size(n+1));             // n=-1 is A1, n=-5 is A5
	}
	
	private static int[] doubleIt(int[] original) {
		int[] result = new int[2];
		result[0] = original[1];
		result[1] = original[0]*2;
		return result;
	}
	
	private static int[] halfIt(int[] original) {
		int[] result = new int[2];
		result[0] = original[1] / 2; 	      // ignore rounding error
		result[1] = original[0];
		return result;
	}
	
	public static void main(String[] args) {
		size("A0");
		size("A00");
		size("A000");
		size("A0000");
		size("A1");
		size("A2");
		size("A3");
		size("A4");
		size("A5");
	}
}
			
