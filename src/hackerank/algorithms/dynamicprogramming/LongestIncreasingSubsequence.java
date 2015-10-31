package hackerank.algorithms.dynamicprogramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//WAP to find the Longest increasing subsequence
public class LongestIncreasingSubsequence{

	public static Integer[] LIS(Integer[] A) {
		int[] m = new int[A.length];
		//Arrays.fill(m, 1);//not important here
		for (int x = A.length - 2; x >= 0; x--) {
			for (int y = A.length - 1; y > x; y--) {
				if (A[x] < A[y] && m[x] <= m[y]) {
					m[x]++;//or use m[x] = m[y] + 1;
				}
			}
		}
		int max = m[0];		//debug and see, the max value will be present at m[0]
		//still check iterating again
		for (int i = 1; i < m.length; i++) {
			if (max < m[i]) {
				max = m[i];
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < m.length; i++) {
			if (m[i] == max) {
				result.add(A[i]);
				max--;
			}
		}
		return result.toArray(new Integer[0]);
	}

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();

		//read and store numbers in array
		Integer [] arr = new Integer[size];
		for(int i=0; i < size; i++){
			arr[i] = s.nextInt();
		}

		//Integer[] arr = { 15, 27, 14, 38, 26, 55, 46, 65, 85 };

		Integer[] result = LIS(arr);

		System.out.println(Arrays.toString(result));
//		System.out.println(result.length);
		
		s.close();
	}

}


