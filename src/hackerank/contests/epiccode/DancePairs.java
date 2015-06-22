package hackerank.contests.epiccode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DancePairs {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		BigInteger cutOff = BigInteger.valueOf(s.nextInt());
		List<BigInteger> boys = new ArrayList<BigInteger>();
		List<BigInteger> girls = new ArrayList<BigInteger>();
		
		for(int i = 0; i < size; i++){
			boys.add(BigInteger.valueOf(s.nextInt()));
		}
		for(int i = 0; i < size; i++){
			girls.add(BigInteger.valueOf(s.nextInt()));
		}
		
		System.out.println(findMaximumPairs(boys, girls, cutOff, size));
		
		s.close();
	}

	private static int findMaximumPairs(List<BigInteger> boys,
			List<BigInteger> girls, BigInteger cutOff, int size) {
		
		List<BigInteger> ascBoys = new ArrayList<BigInteger>(boys);
		List<BigInteger> ascGirls = new ArrayList<BigInteger>(girls);
		List<BigInteger> descBoys = new ArrayList<BigInteger>(boys);
		List<BigInteger> descGirls = new ArrayList<BigInteger>(girls);
		
		Collections.sort(ascBoys);
		Collections.sort(ascGirls);
		Collections.sort(descBoys, Collections.reverseOrder());
		Collections.sort(descGirls, Collections.reverseOrder());
		
		int givenCount = 0;int ascCount = 0;int descCount=0;int ascDescCount = 0;int descAscCount=0;
		int givenAscCount=0;int givenDescCount=0; int ans = 0;
		for(int i=0; i<size; i++){
			if(boys.get(i).subtract(girls.get(i)).abs().compareTo(cutOff) <= 0){
				givenCount++;
			}
			if(boys.get(i).subtract(ascGirls.get(i)).abs().compareTo(cutOff) <= 0){
				givenAscCount++;
			}
			if(boys.get(i).subtract(descGirls.get(i)).abs().compareTo(cutOff) <= 0){
				givenDescCount++;
			}
			if(ascBoys.get(i).subtract(ascGirls.get(i)).abs().compareTo(cutOff) <= 0){
				ascCount++;
			}
			if(descBoys.get(i).subtract(descGirls.get(i)).abs().compareTo(cutOff) <= 0){
				descCount++;
			}
			if(ascBoys.get(i).subtract(descGirls.get(i)).abs().compareTo(cutOff) <= 0){
				ascDescCount++;
			}
			if(descGirls.get(i).subtract(ascBoys.get(i)).abs().compareTo(cutOff) <= 0){
				descAscCount++;
			}
		}
		
//		System.out.println("givenCount = "+givenCount+"givenAscCount = "+givenAscCount+"givenDescCount = "+givenDescCount+
//	"\n ascCount =" +ascCount + " descCount = "+ descCount + " ascDescCount ="+ ascDescCount+ " descAscCount ="+descAscCount);
		
		ans = Math.max(givenDescCount,Math.max(givenAscCount, 
				Math.max(descAscCount, Math.max(givenCount, Math.max(ascCount, Math.max(descCount, ascDescCount))))));
		
		return ans;
	}

}
