package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// sort first by length of string and if length of strings are equal then sort alphabetically
public class CustomSort {
	static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			} else if (o1.length() < o2.length()) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("abd");
		list.add("pmno");
		list.add("lmn");
		Collections.sort(list, new MyComparator());
		for (String element : list) {
			System.out.println(element);
		}
	}
}
