package hackerank.algorithms.warmup;

import java.util.Scanner;

/**
Problem Statement

You are given time in AM/PM format. Convert this into a 24 hour format.

Note Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00PM.

Input Format

Input consists of time in the AM/PM format i.e. hh:mm:ssAM or hh:mm:ssPM 
where 
01≤hh≤12 
00≤mm≤59 
00≤ss≤59

Output Format

You need to print the time in 24 hour format i.e. hh:mm:ss 
where 
00≤hh≤23 
00≤mm≤59 
00≤ss≤59

Sample Input

07:05:45PM
Sample Output

19:05:45
 */
public class TimeConversion {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inputTime = s.next();
		
		String[] timeItervals = inputTime.split(":");
			
		int hours = Integer.parseInt(timeItervals[0]);
		int mins = Integer.parseInt(timeItervals[1]);
		int sec = Integer.parseInt(timeItervals[2].substring(0,2));
		
		String am_pm = timeItervals[2].substring(2);
		
		if(am_pm.equals("PM") && (hours == 12 && mins == 0 && sec == 0)){
			hours = hours + 12;
		}else if(am_pm.equals("PM") && (hours == 12 && (mins > 0 || sec > 0))){
			hours = 12;
		}else if(am_pm.equals("PM") && (hours < 12)){
			hours = hours + 12;
		}else if(am_pm.equals("AM") && hours == 12){
			hours = 0;
		}
		
		System.out.println(String.format("%02d", hours) +":"+timeItervals[1]+":"+
					timeItervals[2].substring(0, 2));		
		
		s.close();
	}

}
