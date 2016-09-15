package hackerank.contests.vgsa;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	  public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        int a = 0 , no = 0 ;

	        Scanner sc = new Scanner(System.in);
	        a = sc.nextInt();
	        int[] arr = new int[a];
	        int n[] = new int[a]; int n1 = 0;
	        for ( int i = 0 ; i < arr.length ; i++ )
	        {
	            arr[i] = sc.nextInt();
	            if ( 0 != i )
	            {
	                if ( arr[i] > arr[i-1] )
	                {
	                    n[1] = arr[i];
	                    no = Math.max(no, 1);
	                }
	                else if ( arr[i] > arr[a] )
	                {
	                    for ( int j = no ; j >= 0 ; j-- )
	                    {
	                        if ( 0 == j )
	                        {
	                            n[++no] = arr[i];
	                            break;
	                        }
	                        if ( arr[i] > n[j] )
	                        {
	                            n[j] = arr[i];
	                            break;
	                        }                       
	                    }
	                }
	                else
	                {
	                    a = i;
	                    n1 = Math.max(n1, no);
	                    no = 0;
	                    Arrays.fill(n, 0);
	                }
	            }
	            else
	            {
	                a = i;
	            }

	        }
	        System.out.println(Math.max(n1, no));   
	    }
}
