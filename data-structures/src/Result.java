import java.util.LinkedHashMap;
import java.util.Map;

public class Result {

	public static void main(String[] args) {
		int result = maximumOccurringDigit("12345678902");
		System.out.println(result);

	}

	public static int maximumOccurringDigit(String text) {

		boolean isStringContainsOnlyInteger = true;
		for (int i = 0; i < text.length(); i++) {
			if (!(text.charAt(i) >= '0' && text.charAt(i) <= '9')) {
				isStringContainsOnlyInteger = false;
			}
		}
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int result = -1;
		if (!isStringContainsOnlyInteger) {
			for (char ch = 0; ch < text.length(); ch++) {
				map.put(ch, map.containsKey(ch)?map.get(ch)+1:1);
			}
			
//			for (int i = 0; i < array.length; i++) {
//				
//			}
		}
		return result;
	}

}
