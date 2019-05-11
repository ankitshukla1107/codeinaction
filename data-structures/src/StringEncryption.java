import java.util.Scanner;

public class StringEncryption {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first string: ");
		String original = input.next();
		System.out.println("Enter second string: ");
		String encrypted = input.next();
		int result = findTotalRotation(original, encrypted);
		System.out.println(result);
	}

	public static int findTotalRotation(String original, String encrypted) {
		int counter = original.length();
		int result = -1;
		if ((original.length() == encrypted.length())
				&& (original.equals(encrypted))) {
			result = 0;
		} else {
			String current = original;
			int countRotation = 0;
			while (counter != 0) {
				char[] temp = new char[current.length()];
				temp[current.length() - 1] = current.charAt(0);
				for (int i = 0; i < current.length() - 1; i++) {
					temp[i] = current.charAt(i + 1);
				}
				counter--;
				current = new String(temp);
				countRotation++;
				if (current.equals(encrypted)) {
					result = countRotation;
				}
			}
		}
		return result;
	}
}