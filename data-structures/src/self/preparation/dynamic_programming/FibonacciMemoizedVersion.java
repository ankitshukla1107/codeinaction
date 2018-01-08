package self.preparation.dynamic_programming;

public class FibonacciMemoizedVersion {

	static int MAX = 100;
	static int[] lookup = new int[20];
	public static void main(String[] args) {
		
		
		
		
		
		/*initialize(lookup);
		System.out.println(fib(6));*/
	}
	
	private static void initialize(int[] lookup){
		for (int i = 0; i < 20; i++) {
			lookup[i] = 0;
		}
	}
	
	private static int fib(int n){
		if(lookup[n]==0){
			if(n<=1){
				lookup[n] = n;
			}else{
				lookup[n] = fib(n-1)+fib(n-2);
			}
		}
		return lookup[n];
	}

}
