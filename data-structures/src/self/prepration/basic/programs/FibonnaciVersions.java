package self.prepration.basic.programs;

import java.util.Scanner;

public class FibonnaciVersions {

	/*
	 * In fibonacci series, next number is the sum of previous two numbers for
	 * example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of
	 * fibonacci series are 0 and 1
	 */

	static int n1 = 0, n2 = 1, n3;
	
	static {
		System.out.println("Helo");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number upto which Fibonacci series is required: ");
		int count = input.nextInt();
		// fibonacciWithoutRecursion(input.nextInt());
		System.out.print(n1 + " " + n2);// printing 0 and 1
		fibonacciUsingRecursion(count - 2);
		input.close();
	}

	static void fibonacciWithoutRecursion(int count) {
		int n1 = 0, n2 = 1, n3;
		System.out.print(n1 + " " + n2);// printing 0 and 1
		for (int i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
	}

	static void fibonacciUsingRecursion(int count) {
		if (count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			fibonacciUsingRecursion(count - 1);
		}
	}

}
