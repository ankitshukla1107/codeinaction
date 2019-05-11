import java.util.Arrays;
import java.util.Scanner;

public class PhilosophicalQuotes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many strings are available as input: ");
		int totalStrings = input.nextInt();
		System.out.println("Total input strings provided are: " + totalStrings);

		String[] strArr = new String[totalStrings];
		for (int i = 0; i < totalStrings; i++) {
			String current = input.next();
			strArr[i] = current;
		}
		Arrays.sort(strArr);
		System.out.println("Printing PQ value of each string");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i] + " " + i);
		}
	}
}
