package hackerank.contests.epiccode;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PerfectHiring {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfCandidates = s.nextInt();
		int patience = s.nextInt();
		int lossPatience = s.nextInt();
		
		List<BigInteger> ratings = new LinkedList<BigInteger>();
		for(int i = 0; i < noOfCandidates; i++){
			BigInteger score = BigInteger.valueOf(s.nextInt());
						
			BigInteger rating = score.multiply(BigInteger.valueOf(patience));			
			ratings.add(rating);
			patience = patience - lossPatience;
		}
		BigInteger val = Collections.max(ratings);
		int index = ratings.indexOf(val)+1;
		System.out.println(index);
		
		s.close();
	}
}
