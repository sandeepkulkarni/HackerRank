package hackerank.algorithms.warmup;

import java.util.Scanner;

public class IsFibo {

	public static void main (String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int maxNo = scanner.nextInt();
		
		int fibonacciNo = 0;
		
		System.out.println("---Print by recursion : ");
		for(int i=1; i <= maxNo; i++){
			fibonacciNo = findFibonacciRecurssion(i);
			
			if(fibonacciNo > maxNo){
				break;
			}
			
			System.out.println(fibonacciNo + " ");
		}
		
		System.out.println("---Print by Normal : ");
		
		System.err.println(findFibonacciNormal(maxNo));
		
		
		scanner.close();
	}

	/**
	 * Method returns fibonacci numbers using recurssion
	 * @param number
	 * @return
	 */
	private static int findFibonacciRecurssion(int number) {		
		if(number == 1 || number == 2){
			return 1;
		}		
		return findFibonacciRecurssion(number-1) + findFibonacciRecurssion(number-2);		
	}
	
	private static int findFibonacciNormal(int number){
		if(number == 1 || number ==2){
			return 1;
		}
		int fib1 = 1, fib2 = 1, temp = 1;
		for(int i=3; i <= number; i++){
			temp = fib1 + fib2;
			fib1 = fib2;
			fib2 = temp;
		}
		return temp;
	}

	
}
