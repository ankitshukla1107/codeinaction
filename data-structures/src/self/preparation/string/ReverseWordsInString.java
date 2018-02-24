package self.preparation.string;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String input = "Welcome to Programming";
		String[] strArr = input.split(" ");
		StringBuilder result = new StringBuilder(input.length());
		for (int i = strArr.length - 1; i >= 0; i--) {
			result.append(strArr[i]+" ");
		}
		System.out.println(result.toString().trim());
	}
}
