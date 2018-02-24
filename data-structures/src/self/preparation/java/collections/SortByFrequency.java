package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SortByFrequency {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 2, 8, 5, 6, 8, 8 };
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int current : arr) {
			if (map.containsKey(current)) {
				map.put(current, map.get(current) + 1);
			} else {
				map.put(current, 1);
			}
		}
		Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);

		Set<Entry<Integer, Integer>> set = treeMap.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(
				set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return 0;
				} else if (o1.getValue() < o2.getValue()) {
					return +1;
				} else {
					return -1;
				}
			}
		});
		for (Map.Entry<Integer, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++) {
				result.add(entry.getKey());
			}
		}
		System.out.println(result);

	}

}
