package hackerank.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameOfThrown1 {

	private static List<String> anagrams = new ArrayList<String>();
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    //base case
	    if (n == 0) {
	    	//System.out.println(prefix);
	    	anagrams.add(prefix);
	    } else {
	        for (int i = 0; i < n; i++){
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}
	
	private static boolean isPalindrome(String input, String anagram){
		return input.equals(new StringBuilder(anagram).reverse().toString());
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String inputString = s.next();
		
		//System.out.println(inputString);
		
		//Part 1 : Find all possible anagrams or permuatations of inputs string
		permutation("",inputString);
		
		//Part 2 : Check if any anagram is a palindrome - if Yes, return true else false
		boolean flag = false;
		for(String str : anagrams){
			if(isPalindrome(inputString, str)) {
				flag = true;
			}
		}
		
		System.out.println(flag ? "YES" : "NO");
		
		s.close();
	}
	
	

}
