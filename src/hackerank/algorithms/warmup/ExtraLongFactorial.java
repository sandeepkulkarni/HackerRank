package hackerank.algorithms.warmup;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {

	private static BigInteger factorial(BigInteger number){
		//base case
		if(number.equals(BigInteger.ZERO)){
			return BigInteger.ONE;
		}else{
			return number.multiply(factorial(number.subtract(BigInteger.ONE)));
		}		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		BigInteger number = new BigInteger(s.next());
		
		BigInteger factorial = factorial(number);
		
		System.out.println(factorial.toString());
		
		s.close();
	}

}
