package self.preparation.string;

import java.util.Arrays;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		char[] result = removeDuplicates("abcaasd".toCharArray());
		for(char ch: result) {
			System.out.print(ch);
		}
	}

	public static char[] removeDuplicates(char[] numbersWithDuplicates) {

		// Sorting array to bring duplicates together
		Arrays.sort(numbersWithDuplicates);
		char[] result = new char[numbersWithDuplicates.length];
		char previous = numbersWithDuplicates[0];
		result[0] = previous;

		for (char i = 1; i < numbersWithDuplicates.length; i++) {
			char ch = numbersWithDuplicates[i];

			if (previous != ch) {
				result[i] = ch;
			}
			previous = ch;
		}
		return result;

	}

}
