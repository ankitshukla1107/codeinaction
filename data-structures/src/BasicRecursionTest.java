
public class BasicRecursionTest {

	public static void main(String[] args) {
		printRecursively(5);

	}
	
	private static void printRecursively(int n) {
		System.out.println("Hello");
		if(n>=1) {
			System.out.println("current n value is: "+ n);
			printRecursively(n-1);
			System.out.println("Value of n after recursion: "+ n);
		}
	}

}
