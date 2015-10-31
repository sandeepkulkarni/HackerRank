package hackerank.contests.indeedprime;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseDilemma {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<Integer,Map<Integer,Integer>> coursesMap = new LinkedHashMap<Integer,Map<Integer,Integer>>();
		
		int noOfTestCases = s.nextInt();
		
		//Populate Input Data into Map
		for(int i=0; i<noOfTestCases; i++){			
			int noOfRelations = s.nextInt();
			Map<Integer,Integer> tempMap = new LinkedHashMap<Integer,Integer>();
			
			for(int j=0; j<noOfRelations; j++){
				int courseNo = s.nextInt();
				int preReqNo = s.nextInt();
				
				tempMap.put(courseNo, preReqNo);
			}
			coursesMap.put(i+1, tempMap);			
		}
		//System.out.println("Courses Map : "+coursesMap);
		
		//Check coursesMap and find semesters required
		Map<Integer, Integer> semestersRequiredMap = calculateSemestersRequired(coursesMap);
		//System.out.println("semestersRequiredMap : "+semestersRequiredMap);
		
		//Print semestersRequiredMap
		for(Map.Entry<Integer, Integer> entry : semestersRequiredMap.entrySet()){
			int caseNo = entry.getKey();
			int semReq = entry.getValue();
			
			if(semReq == -999){
				System.out.println("Case "+caseNo+": Never Ends");
			}else{
				System.out.println("Case "+caseNo+ ": "+semReq+" semester(s)");
			}
			
		}
		
		s.close();
	}

	private static Map<Integer, Integer> calculateSemestersRequired(Map<Integer, Map<Integer, Integer>> coursesMap) {
		Map<Integer, Integer> semestersRequiredMap = new LinkedHashMap<Integer,Integer>();
		
		for(Map.Entry<Integer, Map<Integer, Integer>> entry : coursesMap.entrySet()){
			int caseNo = entry.getKey();
			Map<Integer, Integer> caseCourseMap = entry.getValue();
			
			int semRequired = 1;
			boolean isPossible = false;
			
			for(Map.Entry<Integer, Integer> caseEntry : caseCourseMap.entrySet()){		
				//semRequired = 0;
				int preReq = caseEntry.getValue();			
			
				if(caseCourseMap.containsKey(preReq)){
					semRequired++;									
				}else{
					semRequired++;
					isPossible = true;
					break;
				}				
			}
			
			if(isPossible){
				semestersRequiredMap.put(caseNo, semRequired);
			}else{
				semestersRequiredMap.put(caseNo, -999);	//-999 => Never Ends
			}
			
			
		}
		
		return semestersRequiredMap;
	}

}
