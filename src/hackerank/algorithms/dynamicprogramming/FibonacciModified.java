package hackerank.algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		BigInteger number1 = BigInteger.valueOf(s.nextInt());
		BigInteger number2 = BigInteger.valueOf(s.nextInt());
		int n = s.nextInt();
		
		BigInteger temp = BigInteger.ZERO;
		for(int i=0; i < (n-2); i++){
			BigInteger x = number2.multiply(number2);
			temp = x.add(number1);
			number1 = number2;
			number2 = temp;			
			
		}
		System.out.println(temp);
		
		s.close();
	}
}
