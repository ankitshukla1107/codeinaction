package self.preparation.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class SubStringsOfString {

	public static void main(String[] args) {
		String str = "abb";
		Set<String> uniqueStrings = new LinkedHashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				uniqueStrings.add(str.substring(i, j));
			}
		}

		for (String currentString : uniqueStrings) {
			System.out.println(currentString);
		}

	}

}
