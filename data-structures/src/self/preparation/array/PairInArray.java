package self.preparation.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 	asked in amazon
public class PairInArray {

	// Given an array A[] and a number x, check for pair in A[] with sum as x

	public static void main(String[] args) {
		//int arr[] = { 2, 4, 5, 8, 1, 3 };
		int arr[] = {4,3,1,2,5};
		// printPairsInArray(arr,6);
		 printpairs(arr, 5);
		// printPairsUsingSorting(arr, 6);
	}

	private static void printPairsInArray(int[] arr, int x) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int current : arr) {
			map.put(current, x - current);
		}

		for (int current : arr) {
			if (map.containsKey(x - current) && (x - current != current)) {
				System.out.println(x - current + ", " + current);
			}
		}

	}

	private static final int MAX = 100000; // Max size of Hashmap

	static void printpairs(int arr[], int sum) {
		// Declares and initializes the whole array as false
		boolean[] binmap = new boolean[MAX];

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is ("
						+ arr[i] + ", " + temp + ")");
			}
			binmap[arr[i]] = true;
		}
	}

	private static void printPairsUsingSorting(int arr[], int sum) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;

		while (left < right) {
			if (arr[left] + arr[right] > sum) {
				right--;
			} else if (arr[left] + arr[right] < sum) {
				left++;
			} else {
				System.out.println("Pair with given sum " + sum + " is ("
						+ arr[left] + ", " + arr[right] + ")");
				left++;
				right--;
			}
		}
	}

}
