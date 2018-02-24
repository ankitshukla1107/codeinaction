package self.preparation.string;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter input string: ");
		String first = input.next();
		ReverseString rs = new ReverseString();
		System.out.println(rs.iterativeStringReverse(first));
		rs.recursiveStringReverse(first);
	}
	

	private void recursiveStringReverse(String input) {
		if ((input == null) || (input.length() <= 1))
			System.out.println(input);
		else {
			System.out.print(input.charAt(input.length() - 1));
			recursiveStringReverse(input.substring(0, input.length() - 1));
		}
	}

	private String iterativeStringReverse(String input) {
		char[] arr = input.toCharArray();
		StringBuilder output = new StringBuilder(input.length());
		for (int i = input.length() - 1; i >= 0; i--) {
			output.append(arr[i]);
		}
		return output.toString();
	}

}
