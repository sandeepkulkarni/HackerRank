package hackerank.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<String> inputsList = new ArrayList<String>();

		int noOfInputs = scanner.nextInt();
		if (noOfInputs > 0) {
			for (int i = 0; i <= noOfInputs; i++) {
				String input = scanner.nextLine();
				if (input != null && !input.equals("")) {
					inputsList.add(input);
				}
			}
		}

		if (noOfInputs == inputsList.size()) {

			for (String input : inputsList) {

				String reverse = getInputReversed(input);

				char[] inputChars = input.toCharArray();
				char[] reverseChars = reverse.toCharArray();

				int index = 0;
				boolean isFunny = false;
				while (index < input.length()) {

					if (index != input.length() - 1) {
						int value1 = inputChars[index + 1] - inputChars[index];
						int value2 = reverseChars[index + 1] - reverseChars[index];

						if (Math.abs(value1) == Math.abs(value2)) {
							isFunny = true;							
						} else {
							isFunny = false;
							break;
						}
					}
					index++;
				}

				if (isFunny) {
					System.out.println("Funny");
				} else {
					System.out.println("Not Funny");
				}

			}
		}
		
		scanner.close();
	}

	private static String getInputReversed(String input) {
		return new StringBuilder(input).reverse().toString();
	}
}
