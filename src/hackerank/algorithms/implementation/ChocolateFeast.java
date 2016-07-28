package hackerank.algorithms.implementation;

import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            
            int chocolates = n/c;               //3 = 6/2; eg 6 2 2
            int wrappers = chocolates;          // 3 wrappers of 3 chocolates
            int remaining = 0;                  //init    
            while(wrappers >= m){       
            	remaining = (wrappers/m);      //no.of choc we get from wrappers
            	chocolates += remaining;       //add it to chocolates
            	remaining += wrappers % m;     // 3 % 2 = 1 add the unused wrappers to remaining wrappers
            	wrappers = remaining;          //init wrappers to remaining wrappers            	
            }                       
            System.out.println(chocolates);            
        }
    }

}
