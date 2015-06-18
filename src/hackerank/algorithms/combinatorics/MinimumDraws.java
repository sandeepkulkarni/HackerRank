package hackerank.algorithms.combinatorics;

import java.util.Scanner;

public class MinimumDraws {
    
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        
        int[] inputs = new int[testCases];
        int[] answers = new int[testCases];
        
        for(int i=0; i< testCases; i++){
            inputs[i] = s.nextInt();
            answers[i] = inputs[i] + 1;
        }
        
        //print result
        for(int i=0; i< testCases; i++){
            System.out.println(answers[i]);
        }
        
        
        s.close();
    }
}
