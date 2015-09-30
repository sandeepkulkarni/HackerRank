package hackerank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockandArray {
	
	private static int checkArray(int[] arr) {	        
	        
	        //maintain sum array to keep complexity O(n)  
	        long[] sums = new long[arr.length];
	        
	        //sum left to index
	        int sum = 0;
	        for(int i = 0; i < arr.length; ++i){
	        	sum += arr[i];
	        	sums[i] = sum;
	        }
	        
	        //subtract sum from right to left
	        sum = 0;
	        for(int i = arr.length - 1; i >= 0; --i){
	        	sum += arr[i];
	        	sums[i] = sums[i] - sum;
	        }
	        
	        //If there is an index such that : sum of elements to left = sum of elements to right. Then there should be atleast 1 element = 0 in sums array.
	        //Find using binary search if there one such element
	        return Arrays.binarySearch(sums, 0);
	    }
	    
	    public static void main(String[] args) {
	        
	        Scanner s = new Scanner(System.in);
	        int noOfTests = s.nextInt();
	        
	        for(int i = 0; i < noOfTests; i++) {            
	            int length = s.nextInt();
	            int[] arr = new int[length];
	        
	            //fill in the array
	            for(int j=0; j < length; j++) {
	                arr[j] = s.nextInt();
	            }         
	            
	            //check if there is such an element
	            int value = checkArray(arr);
//	            System.out.println(value);
	            if(value >= 0){
	                System.out.println("YES");
	            }else{
	                System.out.println("NO");
	            }
	            
	        }
	        
	        s.close();
	    }
}
