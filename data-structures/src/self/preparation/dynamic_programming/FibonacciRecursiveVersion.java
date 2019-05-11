package self.preparation.dynamic_programming;

public class FibonacciRecursiveVersion {

	public static void main(String[] args) {
		System.out.println(calculateFibonacci(5));
	}

	private static int calculateFibonacci(int n) {
		if (n < 2)
			return n;
		return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
	}
}
