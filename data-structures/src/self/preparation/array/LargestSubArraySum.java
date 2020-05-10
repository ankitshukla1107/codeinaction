package self.preparation.array;

public class LargestSubArraySum {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		LargestSubArraySum largestSubArraySum = new LargestSubArraySum();
	//	largestSubArraySum.getLargestSubArraySumBasic(arr);
	//	largestSubArraySum.getLargestSubArraySumOptimized(arr);
		largestSubArraySum.getIndexOfLargestSubArraySum(arr);
	}

	// Naive Implementation using dynamic programming- O(n) solution
	private void getLargestSubArraySumBasic(int[] arr) {
		int max_ending_here = 0;
		int max_so_far = 0;
		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		System.out.println(max_so_far);
	}

	// Optimized version of above solution
	private void getLargestSubArraySumOptimized(int[] arr) {
		int max_ending_here = 0;
		int max_so_far = arr[0];
		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
			} else if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		System.out.println(max_so_far);
	}

	private void getIndexOfLargestSubArraySum(int arr[]) {
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		int start = 0, s = 0, end = 0;
		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];

			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		System.out.println("Maximum contiguous sum is :" + max_so_far);
		System.out.println("And index is between " + start + " and " + end);
	}
}
