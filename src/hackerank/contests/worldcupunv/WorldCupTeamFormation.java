package hackerank.contests.worldcupunv;

import java.util.Arrays;
import java.util.Scanner;

public class WorldCupTeamFormation {

	public static void main(String[] args){
        Scanner s = new Scanner(System.in);
		
        //read 10 rating inputs
        int[] ratings = new int[10];
        
        for(int i = 0; i < 10; i++){
             ratings[i] = s.nextInt();
        }

        Arrays.sort(ratings);
        
        int teamScore1, teamScore2 = 0;
        
        teamScore1 = ratings[9] + ratings[7] + ratings[5];
        teamScore2 = ratings[8] + ratings[6] + ratings[4];
        
        //System.out.println(teamScore1 + " , "+teamScore2);
        
        if(teamScore1 >= teamScore2){
        	System.out.println(teamScore1);
        }else{
        	System.out.println(teamScore2);
        }

        s.close();
   }


}
