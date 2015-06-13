package hackerank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Statement

You are given an integer N. Find the digits in this number that exactly divide N and display their count. For N = 24, there are 2 digits - 2 & 4. Both these digits exactly divide 24. So our answer is 2.

Note

If the same number is repeated twice at different positions, it should be counted twice, e.g., For N=122, 2 divides 122 exactly and occurs at ones' and tens' position. So it should be counted twice. So for this case, our answer is 3.
Division by 0 is undefined.
Input Format

The first line contains T (number of test cases) followed by T lines (each containing an integer N).

Constraints 
1 <=T <= 15 
0 < N < 1010

Output Format

For each test case, display the count of digits in N that exactly divide N in separate line.

Sample Input

2
12
1012
Sample Output

2
3
Explanation

2 digits in the number 12 divide the number exactly. Digits at tens' place, 1, divides 12 exactly in 12 parts, and digit at ones' place, 2 divides 12 equally in 6 parts.

1 divides 1012 at two places and 2 divides it at one place. Divide by 0 is an undefined behaviour and it will not be counted.
 *
 */
public class FindDigits {
	
	private static List<Integer> results = new ArrayList<Integer>();
	
	private static void findDigits(List<Integer> inputNumbers){
		
		for(int number : inputNumbers){
			int mainNo = number;
			List<Integer> resultDigits = new ArrayList<Integer>();
			while(number > 0){
				int digit = number % 10;
				if(digit != 0 && mainNo % digit==0){
					resultDigits.add(digit);
				}
				number = number / 10;
			}
			
//			for(int i : resultDigits){
//				System.out.println(i);
//			}
//			
			results.add(resultDigits.size());
			
		}
		
	}
	
	public static void main(String[] args){
		List<Integer> inputNumbers = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		int noOfTests = scanner.nextInt();
		
		for(int i=0; i < noOfTests; i++){
			if(scanner.hasNextInt()){
				inputNumbers.add(scanner.nextInt());
			}
		}
		
		findDigits(inputNumbers);
		
//		System.out.println("-----result---");
		//print results
		for(int result : results){
			System.out.println(result);
		}
		
		scanner.close();
		
	}
}
