package hackerank.contests.vgsa;

import java.util.Scanner;

public class Red {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int total = sc.nextInt();
	    while (total > 0) {
	        total--;
	        int n = sc.nextInt();
	        int[] store = new int[n+1];
	        store[0] = 1;
	        for (int i = 1; i <= n; i++) {
	            store[i] += store[i-1];
	            if (i - 4 >= 0) {
	                store[i] += store[i-4];
	            }
	        }
	        int res = 0;
	        for(int number = 2; number<=store[n]; number++){
	            if(isPrime(number)){
	                res++; 
	            }
	        }
	        System.out.println(res);
	    }
	}
	     
	private static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n!= 2 && n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
