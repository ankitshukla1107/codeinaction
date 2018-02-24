package self.preparation.array;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int arr[] = { 5, 8, 5, 7, 2, 4, 2 };
		Arrays.sort(arr);
		// 2,2,4,5,7,8
		int previous = arr[0];
		int result[] = new int[arr.length];
		result[0] = previous;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != previous) {
				result[i] = arr[i];
			}
			previous = arr[i];
		}

		for (int current : result) {
			System.out.println(current);
		}
	}

}
