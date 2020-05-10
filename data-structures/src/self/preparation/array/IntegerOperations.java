package self.preparation.array;

public class IntegerOperations {

	public static void main(String[] args) {
		//System.out.println(getReverse(1000000045));
		System.out.println(getSumOfSquaresOfIntegers(123));

	}
	
	private static int getReverse(int number) {
		int result = 0;
		if(number==0) {
			return result;
		}
		
		while(number>0) {
			result = result*10+number%10;
			number = number/10;
		}
		
		return result;
	}
	
	private static int getSumOfSquaresOfIntegers(int number) {
		int result = 0;
		if(number==0) {
			return result;
		}
		while(number>0) {
			int remainder = number%10;
			result +=(remainder*remainder);
			number = number/10;
		}
		return result;
	}

}
