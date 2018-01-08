package self.preparation.dynamic_programming;

public class LargestSumContiguousArray {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(getMaxSubArraySum(arr));
	}

	// Kadance Algorithm
	private static int getMaxSubArraySum(int[] arr) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}

}
