package self.prepration.numbers;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(reverse(123));
	}

	private static int reverse(int number){
		int result = 0 ;
		//result = Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
		while(number>0){
			int d = number%10;
			result = result*10+d;
			number = number/10;
		}
		
		return result;
	}
}
