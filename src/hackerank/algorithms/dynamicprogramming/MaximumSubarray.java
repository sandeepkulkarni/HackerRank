package hackerank.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * Largest Sum Contiguous Subarray  : 
 * 
 * Geeks-for-Geeks : http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Youtube : https://www.youtube.com/watch?v=EK71U-vTOt4
 * 
 * Kadane’s Algorithm:
 * We have to find a maximum summation in an array between x and y
 * such that its greater than all possible summation possible in array  
 * 
 */
public class MaximumSubarray {
	
	private static int maximumSubarray(int[] arr){
		int bestSum = 0;
		int maxTillHere = 0; 
		
		//Loop through all elements - O(n)
		for(int i=0; i < arr.length; i++){
			//a) Add each element to maxTillHere 
			maxTillHere = maxTillHere + arr[i];
			
			//b) if maxTillHere becomes negative, reset it to 0
			if(maxTillHere < 0){
				maxTillHere = 0;
			}
			//c) if maxTillHere, becomes greater the maxSoFar, update
			if(bestSum < maxTillHere){
				bestSum = maxTillHere;
			}		
		}
		return bestSum;
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for(int i=0; i < tests; i++){
			int size = s.nextInt();
			int[] arr = new int[size];
			
			for(int j=0; j < size; j++){
				arr[j] = s.nextInt();
			}
			//calculate
			int contigousSum = maximumSubarray(arr);
			int nonContigousSum = addAllPositives(arr);
			//print
			if(contigousSum > 0 || nonContigousSum > 0){
				System.out.println(contigousSum + " " + nonContigousSum);
			}else{
				System.out.println(arr[0] + " " + arr[0]);
			}
		}
		
		s.close();
	}
	
	private static int addAllPositives(int[] arr){
		int sum = 0;
		for(int i=0; i < arr.length; i++){
			if(arr[i] > 0){
				sum = sum + arr[i];
			}
		}
		return sum;
	}

}
