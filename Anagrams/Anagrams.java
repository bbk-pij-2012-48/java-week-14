import java.util.ArrayList;
import java.util.ListIterator;

public class Anagrams {
	public static ArrayList<String> anagram(String original) {
		ArrayList<String> results = new ArrayList<String>();
		anagram("", original, results);
		return results;		
	}
	
	private static void anagram(String prefix, String scramble, ArrayList<String> results) {
		if(scramble.length() == 1) {
			results.add(prefix + scramble);
			return;
		}
		StringBuffer tmp;
		String newPrefix, newScramble;
		for(int i=0 ; i<scramble.length() ; i++) {
			newPrefix = prefix + scramble.substring(i,i+1);
			tmp = new StringBuffer(scramble);
			tmp.deleteCharAt(i);
			newScramble = tmp.toString();
			anagram(newPrefix, newScramble, results);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> anagrams = anagram("mia");
		ListIterator itr = anagrams.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

