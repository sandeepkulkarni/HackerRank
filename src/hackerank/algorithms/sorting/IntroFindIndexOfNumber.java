package hackerank.algorithms.sorting;

import java.util.Scanner;

public class IntroFindIndexOfNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int value = s.nextInt();
		int size = s.nextInt();
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			int num = s.nextInt();
			arr[i] = num;
		}

		System.out.println(getIndexOfValue(arr, value));

		s.close();
	}

	private static int getIndexOfValue(int[] arr, int value) {

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}

}
