package hackerank.contests.epiccode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BeginEnd {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int length = s.nextInt();
		String inputString = s.next();

		//System.out.println(findBeginEndSubstringCount(inputString, length));
		
		long finalValue = (long) findFunctionCount(inputString, length);
		System.out.println(finalValue);

		s.close();
	}
	
	private static double findFunctionCount(String inputString, int length){
		
		//populate occurenceMap
		Map<Character, Integer> occurenceMap = new HashMap<Character, Integer>();
		for(int i = 0; i < inputString.length(); i++){
			char key = inputString.charAt(i);
			if(occurenceMap.containsKey(key)){
				int count = occurenceMap.get(key);
				occurenceMap.put(key, count+1);				
			}else{
				occurenceMap.put(key, 1);
			}
		}
		//System.out.println(occurenceMap);
		
		double singleCount = 0;
		double count = 0;
		for(Map.Entry<Character, Integer> entry : occurenceMap.entrySet()){
			if(entry.getValue() == 1){
				singleCount = singleCount + 1;				
				inputString = inputString.replace(entry.getKey().toString(), "");
			}else{
				double frequency = entry.getValue();
				count = (count + ((frequency + 1) * (frequency / 2)));
			}
		}
		
		//System.out.println("Reduced string = "+ inputString + " singleCount = "+singleCount + " count = "+count);
		
		return count + singleCount;
	}

	/*private static long findBeginEndSubstringCount(String inputString, int length) {
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
	}*/

}

