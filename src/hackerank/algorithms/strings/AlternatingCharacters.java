package hackerank.algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int noOfTests = s.nextInt();
		
		for(int i=0; i < noOfTests; i++){
			String input = s.next();
			
			int deletions = getNoOfDeletions(input);
			System.out.println(deletions);
		}		
		s.close();
	}
	
	private static int getNoOfDeletions(String input){
		int count = 0;
		
		char first = input.charAt(0);
		for(int i=1; i < input.length(); i++){
			if(input.charAt(i) == first){
				count++;
			}else{
				first = input.charAt(i);
			}
		}
		
		return count;
	}

}
