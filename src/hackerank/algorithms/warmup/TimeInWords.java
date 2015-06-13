package hackerank.algorithms.warmup;

import java.util.Scanner;

public class TimeInWords {

	private static String[] hours = {"","one","two","three","four","five","six","seven","eight","nine",
									"ten","eleven","twelve","one"};
	
	private static String[] minutes = {"","one","two","three","four","five","six","seven","eight","nine",
		"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
		"twenty one","twenty two","twenty three", "twenty four", "twenty five", "twenty six","twenty seven","twenty eight","twenty nine"};
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int h = s.nextInt();
		int m = s.nextInt();
		
		String words = "";
		if(m == 0){										//special case
			words = hours[h] + " o' clock";
		}else if (m == 30){								//special case
			words = "half past " + hours[h]; 
		}else if(m == 1){								//special case
			words = minutes[m] + " minute past " + hours[h]; 
		}else if(m == 15){								//special case
			words = "quarter past " + hours[h];
		}else if (m == 45){								//special case
			words = "quarter to " + hours[h+1];
		}else if(m < 30){
			words = minutes[m] + " minutes past " + hours[h]; 
		}else if ((60-m) == 1){							//special case
			words = minutes[60-m] + " minute to " + hours[h+1];
		}else if (m > 30){
			words = minutes[60-m] + " minutes to " + hours[h+1];
		}
		
		System.out.println(words);
		
		s.close();
	}

}
