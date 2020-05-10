package self.preparation.array;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int arr[] = {5,2,3,4,1,7};
	//	Arrays.sort(arr);
		System.out.println(getMissingNumber(arr));

	}
	
	private static int getMissingNumber(int arr[]) {
		int actualSum =0;
		for(int i=1;i<=arr.length+1;i++) {
			actualSum+=i;
		}
		
		int expectedSum=0;
		for (int i = 0; i < arr.length; i++) {
			expectedSum+=arr[i];
		}
		 
		return actualSum-expectedSum;
		
	}

}
