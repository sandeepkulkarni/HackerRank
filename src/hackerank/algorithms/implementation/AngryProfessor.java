package hackerank.algorithms.implementation;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int noOfTests = s.nextInt();
		
		for(int i=0; i < noOfTests; i++){
			int noOfStudents = s.nextInt();
			int threshold = s.nextInt();
			
			int[] times = new int[noOfStudents];
			int onTimeCount = 0;
			
			//store times
			for(int j=0; j < times.length; j++){
				int time = s.nextInt();
				if(time <= 0){
					onTimeCount++;
				}
				times[j]=time;
			}
			
			if(onTimeCount < threshold){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}			
		}		
		s.close();
	}
}
