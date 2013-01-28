public class Palindrome {
	public static boolean palindrome(String original) {
		if(original.length() == 0)
			return true;
		if(original.charAt(0) != original.charAt(original.length()-1))
			return false;
		original = original.substring(1,original.length()-1);
		return palindrome(original);
	}
	
	
	public static void main(String[] args) {
	}
}
