package hackerank.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Running output of string "abcd":

Step 1: Merge [a] and b: [ba, ab]

Step 2: Merge [ba, ab] and c: [cba, bca, bac, cab, acb, abc]

Step 3: Merge [cba, bca, bac, cab, acb, abc] and 
        d: [dcba, cdba, cbda, cbad, dbca, bdca, bcda, bcad, dbac, bdac, badc, 
        bacd, dcab, cdab, cadb, cabd, dacb, adcb, acdb, acbd, dabc, adbc, abdc, abcd]
 */
public class Anagrams {

	/**
	 * List permutation of a string
	 * 
	 * @param s the input string
	 * @return  the list of permutation
	 */
	public static ArrayList<String> permutation(String s) {
	    // The result
	    ArrayList<String> res = new ArrayList<String>();
	    // If input string's length is 1, return {s}
	    if (s.length() == 1) {
	        res.add(s);
	    } else if (s.length() > 1) {
	        int lastIndex = s.length() - 1;
	        // Find out the last character
	        String last = s.substring(lastIndex);
	        // Rest of the string
	        String rest = s.substring(0, lastIndex);
	        // Perform permutation on the rest string and
	        // merge with the last character
	        res = merge(permutation(rest), last);
	    }
	    return res;
	}

	/**
	 * @param list a result of permutation, e.g. {"ab", "ba"}
	 * @param c    the last character
	 * @return     a merged new list, e.g. {"cab", "acb" ... }
	 */
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	    // Loop through all the string in the list
	    for (String s : list) {
	        // For each string, insert the last character to all possible postions
	        // and add them to the new list
	        for (int i = 0; i <= s.length(); ++i) {
	            String ps = new StringBuffer(s).insert(i, c).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	}
	
	
	public static void main(String[] args){
		System.out.println("Enter input string: ");
		Scanner s = new Scanner(System.in);
		
		List<String> anagrams = permutation(s.next());
		
		for (String _anagram : anagrams) {
			System.out.println(_anagram);
		}
		
		s.close();
	}
	
}
