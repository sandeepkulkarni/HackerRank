package hackerank.algorithms.search;

import java.util.Scanner;

public class IceCreamParlor {
	  public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        
	        int noOfTests = s.nextInt();
	        
	        for(int i=0; i < noOfTests; i++){
	            int amount = s.nextInt();
	            int noOfFlavors = s.nextInt();
	            
	            //fill flavors array
	            int[] flavors = new int[noOfFlavors];
	            for(int j=0; j < noOfFlavors; j++){
	                flavors[j] = s.nextInt();
	            }
	            
	            //check 2 flavors cost = amount
	            boolean flag = false;
	            for(int x=0; x < noOfFlavors; x++){
	            	for(int y=x+1; y < noOfFlavors; y++){
	            		if(flavors[x] + flavors[y] == amount){
	            			int index1 = x + 1;
	            			int index2 = y + 1;
		                    System.out.println(index1 + " "+ index2);
		                    flag = true;
		                    break;
		                }
	            	}
	            	if(flag) {
	            		break;
	            	}
	                                    
	            }
	        }
	        
	        s.close();
	    } 
}
