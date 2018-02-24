package self.preparation.string;

public class NumberCheckInString {

	public static void main(String[] args) {
		String str = "abc1def";
		char[] strArr = str.toCharArray();
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] > '0' && strArr[i] < '9') {
				System.out.println("Number is present in given string");
			}
		}
	}
}
