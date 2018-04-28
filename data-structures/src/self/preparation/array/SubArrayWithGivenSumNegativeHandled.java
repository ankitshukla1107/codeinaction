package self.preparation.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSumNegativeHandled {

	public static void main(String[] args) {
		int arr[] = {10, 2, -2, -20, 10};
		SubArrayWithGivenSumNegativeHandled.getSubArrayWithGivenSumNegativeHandled(arr, -10);
	}
	
	private static void getSubArrayWithGivenSumNegativeHandled(int[] arr, int sum){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curr_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			curr_sum+=arr[i];
			if(curr_sum==sum){
				System.out.println("subarray with given sum is found between "+0+" and "+i);
				return;
			}			
			if(map.containsKey(curr_sum-sum)){
				System.out.println("subarray with given sum is found between "+map.get(curr_sum-sum)+1 +" and"+ i);
				return;
			}else{
				map.put(curr_sum, i);
			}
		}
		System.out.println("No subarray with given sum exists");
	}

}
