package self.preparation.array;

public class LargestSubArraySumNegativeHandled {

	public static void main(String[] args) {
		int arr[] = { -2, -10, -3, -5, -9 };
		int result = LargestSubArraySumNegativeHandled.maxSubArraySum(arr);
		System.out.println(result);
	}

	private static int maxSubArraySum(int arr[]) {
		int max_so_far = arr[0];
		int max_ending_here = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}
}
