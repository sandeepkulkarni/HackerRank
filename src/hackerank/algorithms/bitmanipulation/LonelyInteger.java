package hackerank.algorithms.bitmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Problem Statement

There are N integers in an array A. All but one integer occur in pairs. Your task is to find the number that occurs only once.

Input Format

The first line of the input contains an integer N, indicating the number of integers. The next line contains N space-separated integers that form the array A.

Constraints

1≤N<100 
N % 2=1 (N is an odd number) 
0≤A[i]≤100,∀i∈[1,N]
Output Format

Output S, the number that occurs only once.

Sample Input:1

1
1
Sample Output:1

1
Sample Input:2

3
1 1 2
Sample Output:2

2
 */
public class LonelyInteger {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++){
			arr[i] = s.nextInt();
		}
		
		//Count the no. of times value is present in array
		Map<Integer, Integer> mapCount = calculateCountOfElements(arr);
		//System.out.println(mapCount);
		
		int result = findLonelyInteger(mapCount);		
		System.out.println(result);
		
		s.close();
	}
	
	private static Map<Integer, Integer> calculateCountOfElements(int[] arr) {
		Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();		
		for (int i = 0; i < arr.length; i++){
			if(mapCount.containsKey(arr[i])){
				int value = mapCount.get(arr[i]);
				value = value + 1;
				mapCount.put(arr[i], value);
			}else{
				mapCount.put(arr[i], 1);
			}
		}		
		return mapCount;
	}
	
	private static int findLonelyInteger(Map<Integer, Integer> mapCount) {
	    int lonelyInteger = 0;	    
		for(Map.Entry<Integer, Integer> entry : mapCount.entrySet()){
	    	if(entry.getValue() % 2 == 1){
	    		lonelyInteger = entry.getKey();
	    	}
	    }
		return lonelyInteger;
	}
	

}
