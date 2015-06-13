package hackerank.algorithms.warmup;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int totalNos = s.nextInt();
		
		List<Integer> positives = new ArrayList<Integer>();
		List<Integer> negatives = new ArrayList<Integer>();
		List<Integer> zeros = new ArrayList<Integer>();
		
		for(int i=0; i < totalNos; i++){
			int value = s.nextInt();
			if(value == 0){
				zeros.add(value);
			}else if(value > 0){
				positives.add(value);
			}else{
				negatives.add(value);
			}
		}
		
		double positive = positives.size();
		double negative = negatives.size();
		double zero = zeros.size();
		
		NumberFormat nf = new DecimalFormat("#0.000");
		
		System.out.println(nf.format(positive/totalNos));	//positive
		System.out.println(nf.format(negative/totalNos));	//negative
		System.out.println(nf.format(zero/totalNos));	//zeros
		
		s.close();

	}

}
