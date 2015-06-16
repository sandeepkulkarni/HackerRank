package hackerank.algorithms.sorting;

import java.util.Scanner;

public class InsertionSort1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		int[] ar = new int[size];
		
		for(int i=0; i<size; i++){
			ar[i] = s.nextInt();
		}
		
		insertIntoSorted(ar);
		
		s.close();
	}

	public static void printArray(int[] ar){		
		for(int i=0; i<ar.length; i++){
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
	
	public static void insertIntoSorted(int[] ar) {
		int x = ar[ar.length-1];
		
		for(int i=ar.length-1; i >= 0; i--){
			int compareValue = 0;
			if(i == 0){
				ar[i] = x;
				printArray(ar);
				break;
			}else{
				compareValue = ar[i-1];
			}			
			
			if(compareValue > x){
				ar[i] = compareValue;
				printArray(ar);
			}else if(compareValue < x){
				ar[i] = x;
				printArray(ar);
				break;
			}
		}

	}
}
