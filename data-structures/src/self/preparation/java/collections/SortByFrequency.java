package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByFrequency {
	
	class Data {
		int value, count;
		Integer index;

		public Data(int value, int count, int index) {
			this.value = value;
			this.count = count;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Data [value=" + value + ", count=" + count + ", index=" + index + "]";
		}
	}

	public void customSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		Map<Integer, Data> map = new HashMap<Integer, Data>();
		Data data = null;
		for (int i = 0; i < arr.length; i++) {
			data = map.get(arr[i]);
			if (data == null) {
				map.put(arr[i], new Data(arr[i], 1, i));
			} else {
				data.count++;
			}
		}

		// sort based on custom comparator
		// Data[] values = (Data[])map.values().toArray();
		Set<Map.Entry<Integer, Data>> entrySet = map.entrySet();
		List<Map.Entry<Integer, Data>> list = new ArrayList<Map.Entry<Integer, Data>>(entrySet);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Data>>() {
			@Override
			public int compare(Entry<Integer, Data> o1, Entry<Integer, Data> o2) {
				if (o1.getValue().count > o2.getValue().count) {
					return -1;
				} else if (o1.getValue().count < o2.getValue().count) {
					return 1;
				} else {
					return o1.getValue().index.compareTo(o2.getValue().index);
				}
			}
		});

		int k = 0;
		for (Entry<Integer, Data> entry : list) {
			data = entry.getValue();
			for (int j = 0; j < data.count; j++) {
				arr[k++] = data.value;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 2, 2, 8, 5, 6, 8, 8 };
		new SortByFrequency().customSort(arr);
		for (int i : arr) {
			System.out.println(i + " ");
		}
	}
}
