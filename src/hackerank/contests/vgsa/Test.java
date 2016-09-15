package hackerank.contests.vgsa;

import java.util.Scanner;

public class Test {
	

		public static int length(long a){
			int len = 0;
			while(a!=0){
				len++;
				a = a>>1;
			}
			return len;
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int T = scanner.nextInt();
			for(int t = 0; t  < T ; t++){
				
				long A = scanner.nextInt();
				long B = scanner.nextInt();
				long result = 0;
				//while(A > 0 && B > 0){
					int lenA = length(A);
					int lenB = length(B);
					if(lenA > lenB){
						A =  A ^ (1l << lenA);
						B =  B ^ (1l << lenB - 1);
					}
					else{
						result |= (1l << lenA - 1);
						A = A ^ (1l << lenA - 1);
						B = B ^ (1l << lenB - 1);
					}
//				}
				System.out.println(result);
			}
		}

	}
