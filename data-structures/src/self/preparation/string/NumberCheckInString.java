package self.preparation.string;

public class NumberCheckInString {

	public static void main(String[] args) {
//		String str = "abc09def";
//		char[] strArr = str.toCharArray();
//		for (int i = 0; i < strArr.length; i++) {
//			if (strArr[i] >= '0' && strArr[i] <= '9') {
//				System.out.println("Number is present in given string");
//			}
//		}
		System.out.println(isStringContainsOnlyInteger("123a4"));
	}
	
	private static boolean isStringContainsOnlyInteger(String str) {
		boolean isStringContainsOnlyInteger = true;
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				isStringContainsOnlyInteger = false;
			}
		}
		return isStringContainsOnlyInteger;
	}
}
