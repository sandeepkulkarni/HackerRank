package hackerank.algorithms.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TwoArrays {
	
	private static boolean isGreaterThanK(Integer[]a, Integer[]b, int k){
		boolean flag = true;
		for(int i = 0; i < a.length; i++){
			if(a[i] + b[i] < k){
				flag = false;
				break;
			}
		}		
		return flag;		
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int noOfTests = scanner.nextInt();
		
		for(int i=0; i < noOfTests; i++){
			int length = scanner.nextInt();
			int k = scanner.nextInt();
			
			Integer[] a = new Integer[length];
			Integer[] b = new Integer[length];
			
			//populate both arrays
			for(int j=0; j < a.length; j++){
				a[j] = scanner.nextInt();
			}
			for(int j=0; j < b.length; j++){
				b[j] = scanner.nextInt();
			}
			
			//Sort A in asc order
			Arrays.sort(a);			
			//Sort B in desc order
			Arrays.sort(b, Collections.reverseOrder());
			
			//print ans
			boolean flag =  isGreaterThanK(a, b, k);
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
		scanner.close();
	}

}
