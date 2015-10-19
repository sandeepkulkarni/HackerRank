package hackerank.algorithms.strings;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String s1 = s.next();
		String s2 = s.next();
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
//		Arrays.sort(c1); Arrays.sort(c2);
		
		for(int i=0; i < c1.length; i++){	//loop c1 - if match found in c2, set c1's index to 0 and c2's index to 0
			char c =  c1[i];
			boolean found = false;
			for(int j=0; j < c2.length; j++){
				if(c2[j] == c){
					c2[j] = 0;
					found = true;
					break;
				}
			}
			
			if(found == true){
				c1[i] = 0;
			}			
		}
		
		//loop through both arrays and count non-zeros
		int count = 0;
		for(int i=0; i < c1.length; i++){
			if(c1[i] != 0){
				count = count + 1;
			}
		}
		for(int i=0; i < c2.length; i++){
			if(c2[i] != 0){
				count = count + 1;
			}
		}
		
		System.out.println(count);
		
		
		s.close();
	}

}
