package hackerank.algorithms.dynamicprogramming;

import java.util.Scanner;
/**
 Inputs :
5 6
1 2 3 4 1
3 4 1 2 1 3
 */
public class LongestCommonSubsequence {
    
    private static void LCS(int[] a, int[] b, int n, int m){
        //Memoization table which is used to store each subproblem solution
    	int[][] L = new int[n+1][m+1];
        
        for(int i=0; i <= n; i++){
        	for(int j=0; j <= m; j++){
        		//LCS DP conditions
        		if(i==0 || j==0){
        			L[i][j] = 0;
        		}else if(a[i-1] == b[j-1]){
        			L[i][j] = 1 + L[i-1][j-1];
        		}else{
        			L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        		}
        	}
        }
        
        //Print to see the table
        for(int i=0; i < n; i++){
        	for(int j=0; j < m; j++){
        		System.out.print(L[i][j] + " ");
        	}
        	System.out.println();
        }
        
        System.out.println("Length of Longest common subsequence : " + L[n][m]);
        
        //Print the Longest Common Subsequence
        int index = L[n][m];
        int[] lcs_result = new int[index];
        
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
        	//if last char same put in result
        	if(a[i-1] == b[j-1]){
        		lcs_result[index-1] = a[i-1];
        		i--; j--; index--;
        	}else if (L[i-1][j] > L[i][j-1]){
        		i--;
        	}else{
        		j--;
        	}
        }//end while
        
        for(int k=0; k < lcs_result.length; k++){
        	System.out.print(lcs_result[k] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int m = s.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[m];
        
        //populate both the arrays
        for(int i=0; i < n; i++){
            a[i] = s.nextInt();
        }
        for(int i=0; i < m; i++){
            b[i] = s.nextInt();
        }
        
        //Call LCS recursively
        LCS(a, b, n, m);
        
        s.close();
    }
}