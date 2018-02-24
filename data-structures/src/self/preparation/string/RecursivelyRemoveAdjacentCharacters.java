package self.preparation.string;

public class RecursivelyRemoveAdjacentCharacters {

	public static void main(String[] args) {
		String string = "ABCCBCBA";//--> ABBCBA--> ACBA
		char[] str = string.toCharArray();
		int j = 0;
		for(int i=1;i<=str.length;i++){
			while((str[i]==str[j]) && (j>=0)){ // cancel pairs
				i++;
				j--;
			}
			str[++j] = str[i];
		}
		String result = new String(str);
		System.out.println(result);
	}

}
