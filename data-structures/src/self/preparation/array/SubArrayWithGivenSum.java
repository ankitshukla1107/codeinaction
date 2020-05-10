package self.preparation.array;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int arr[] = {2,3,4,2,5,5};//{15, 2, 4, 8, 9, 5, 10, 23};
		SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
		subArrayWithGivenSum.getSubArrayWithGivenSum(arr, 10);
		//subArrayWithGivenSum.getSubArrayWithGivenSumOptimized(arr, 23);
	}
	
	// O(n*n) solution- Naive Approach
	private void getSubArrayWithGivenSum(int[] arr, int sum){
		int curr_sum;
		for (int i = 0; i < arr.length; i++) {
			curr_sum = arr[i];
			for (int j = i+1; j <= arr.length; j++) {
				if(curr_sum==sum){
					int p = j-1;
					System.out.println("sum found between: "+i+","+p);
					return;
				}
				if(curr_sum>sum){
					break;
				}
				curr_sum = curr_sum+arr[j];
			}
		}
		System.out.println("No subarray found");
	}
	
	// O(n) solution- Optimized Version
	private void getSubArrayWithGivenSumOptimized(int[] arr, int sum){
		int curr_sum = arr[0], start=0;
		for (int i = 1; i < arr.length; i++) {
			while (curr_sum>sum && start<i-1) {
				curr_sum = curr_sum-arr[start];
				start++;
			}
			if(curr_sum==sum){
				int p = i-1;
				System.out.println("sum found between: "+start+","+p);
				return;
			}
			if(i<arr.length){
				curr_sum+=arr[i];
			}
		}
		System.out.println("No subarray found");
	}
}
