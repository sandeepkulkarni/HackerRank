package hackerank.algorithms.implementation;

import java.util.Scanner;

public class SherlockBeast {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int tests = s.nextInt();

		for (int i = 0; i < tests; i++) {
			int target = s.nextInt();
			int threes = 0;
			int fives = 0;
			int digits = target;
			while (digits > 0) {
				if (digits % 3 == 0) {
					fives = digits;
					break;
				}
				digits -= 5;
			}
			threes = target - digits;
			if (digits < 0 || threes % 5 != 0) {
				System.out.println("-1");
				continue;
			}
			StringBuilder sb = new StringBuilder(target);
			while (fives-- > 0) {
				sb.append("5");
			}
			while (threes-- > 0) {
				sb.append("3");
			}
			System.out.println(sb.toString());


		}

		s.close();
	}

}
