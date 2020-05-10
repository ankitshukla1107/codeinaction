package self.preparation.string;

public class StringFirstCharUpperConversion {

	public static void main(String[] args) {
		String arr = "hello world arpit";
		convertFirstCharToUpper(arr);
	}
	
	private static void convertFirstCharToUpper(String string) {
		String[] strArr = string.split(" ");
		for (String current : strArr) {
			String currentModified = current.substring(0, 1).toUpperCase() + current.substring(1);
			System.out.println(currentModified);
		}
	}

}
