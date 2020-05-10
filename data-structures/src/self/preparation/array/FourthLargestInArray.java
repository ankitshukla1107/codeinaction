package self.preparation.array;

public class FourthLargestInArray {

	public static void main(String[] args) {
		int arr[] = {5, 1, 2, 6, 4, 10, 7};
		System.out.println(getFourthLargestElement(arr));
	}
	
	private static int getFourthLargestElement(int[] arr) {
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int thirdLargest = Integer.MIN_VALUE;
		int fourthLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>firstLargest ) {
				fourthLargest = thirdLargest;
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = arr[i];
			}else if(arr[i]>secondLargest) {
				fourthLargest = thirdLargest;
				thirdLargest = secondLargest;
				secondLargest = arr[i];
			}else if(arr[i]>thirdLargest) {
				fourthLargest = thirdLargest;
				thirdLargest = arr[i];
			}else if(arr[i]>fourthLargest) {
				fourthLargest = arr[i];
			}
		}
		
		return fourthLargest;
	}

}
