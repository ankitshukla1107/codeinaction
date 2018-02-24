package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetMapSorting {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("Ankit");
		set.add("Amit");
		set.add("bablu");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("Map Sorting...");
		Map<String, String> map = new TreeMap<String, String>();
		map.put("DEF", "1");
		map.put("ABC", "2");
		map.put("WDR", "3");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"-->"+ entry.getValue());
		}
	}
		
}
