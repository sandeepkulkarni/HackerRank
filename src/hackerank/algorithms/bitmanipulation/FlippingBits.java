package hackerank.algorithms.bitmanipulation;

import java.util.Scanner;

/**
Problem Statement

You will be given a list of 32 bits unsigned integers. You are required to output the list of the unsigned integers you get by flipping bits in its binary representation (i.e. unset bits must be set, and set bits must be unset).

Input Format

The first line of the input contains the list size T, which is followed by T lines, each line having an integer from the list.

Constraints

1≤T≤100 
0≤integer<232
Output Format

Output one line per element from the list with the requested result.

Sample Input

3 
2147483647 
1 
0
Sample Output

2147483648 
4294967294 
4294967295
 */
public class FlippingBits {

	private static String convertToBinary(long number){
		String binaryValue = Long.toBinaryString(number);
		String finalValue = "";
		if(binaryValue.length() <= 32) {
			int remaining = 32 - binaryValue.length();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < remaining; i++){
				sb.append("0");
			}
			finalValue = sb.toString() + binaryValue;
		}
		return finalValue;
	}
	
	private static String flipBinaryValue(String binaryValue){
		char[] chars = binaryValue.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < chars.length; i++){
			if(chars[i] == '0'){
				sb.append("1");
			}else if(chars[i] == '1'){
				sb.append("0");
			}
		}
		
		return sb.toString();
	}
	
	public static long binaryToInteger(String binary){
	    char[] numbers = binary.toCharArray();
	    long result = 0;
	    long count = 0;
	    for(int i=numbers.length-1;i>=0;i--){
	         if(numbers[i]=='1'){
	        	 result+=(long)Math.pow(2, count);
	         }
	         count++;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		
		long[] unsignedInts = new long[size];
		for(int i = 0; i < size; i++){
			unsignedInts[i] = s.nextLong();
		}
		
		//convert and print
		for(int i = 0; i < size; i++){
			String binaryValue = convertToBinary(unsignedInts[i]);
			String fipppedValue = flipBinaryValue(binaryValue);
			
			//System.out.println(binaryValue);
			//System.out.println(fipppedValue);
			System.out.println(binaryToInteger(fipppedValue));
			
		}
		
		s.close();
	}

}
