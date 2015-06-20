package hackerank.contests.epiccode;

import java.util.Scanner;

public class BeginEnd {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int length = s.nextInt();
		String inputString = s.next();

		System.out.println(findBeginEndSubstringCount(inputString, length));

		s.close();
	}

	private static long findBeginEndSubstringCount(String inputString, int length) {
		StringBuilder sub = new StringBuilder();
		long count = 0;		
		for (int i = 0; i < length; i++) {
			for (int j = 1; j <= length - i; j++) {
				String str = inputString.substring(i, i + j); 
				if(str.length() == 1){
					count = count + 1;
				}else {
					if(str.substring(0, 1).equals(str.substring(str.length() - 1, str.length()))){
						count = count + 1;
					}
				}
				sub.append(str).append("\n");
			}
		}
		System.out.println(sub.toString());
		return count;
	}

}

