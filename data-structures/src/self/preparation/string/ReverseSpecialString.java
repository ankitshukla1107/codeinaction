package self.preparation.string;

public class ReverseSpecialString {

	public static void main(String[] args) {
		String str = "a,bc!d'e";
		char[] strArr = str.toCharArray();
		int l = 0, r = str.length() - 1;
		while (l < r) {
			if(!Character.isAlphabetic(strArr[l])) {
				l++;
			} 
			if(!Character.isAlphabetic(strArr[r])) {
				r--;
			} else {
				char temp = strArr[l];
				strArr[l] = strArr[r];
				strArr[r] = temp;
			}
		}
		String result = new String(strArr);
		System.out.println(result);
	}

}
