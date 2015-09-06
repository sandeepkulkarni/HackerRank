package hackerank.algorithms.warmup;

import java.util.Scanner;

public class SimpleArraySum {

	private static int[] arr = new int[1000];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sizeOfArray = s.nextInt();
		
		for(int i=0; i < sizeOfArray; i++){
			arr[i] = s.nextInt();
		}
		computeSum(sizeOfArray);	
		s.close();
	}

	private static void computeSum(int sizeOfArray) {
		int sum = 0;
		for(int i=0; i < sizeOfArray; i++){
			sum = sum + arr[i];
		}		
		System.out.println(sum);
	}
}
