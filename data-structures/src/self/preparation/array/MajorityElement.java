package self.preparation.array;

//	asked in amazon

// A majority element in an array A[] of size n is an element that appears more than n/2 times 
// (and hence there is at most one such element).
public class MajorityElement {

	public static void main(String[] args) {
	//	int[] arr = {3,3,4,2,4,4,2,4,4};
		int[] arr = {1, 3, 3, 1, 2};
		int maxOccuringElement = getMostFrequentElement(arr);
		if(isMajorityElement(arr, maxOccuringElement)){
			System.out.println("Majority element is: "+ maxOccuringElement);
		}else{
			System.out.println("There is no majority element");
		}
		
	}
	
	private static boolean isMajorityElement(int arr[], int maxOccuringElement){
		int count = 0;
		boolean result = false;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==maxOccuringElement){
				count++;
			}
		}
		if(count>arr.length/2){
			result = true;
		}
		return result;
	}
	
	// Moore's voting algorithm
	private static int getMostFrequentElement(int arr[]){
		int count = 1, majIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==arr[majIndex]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				majIndex = i;
				count = 1;
			}
		}
		return arr[majIndex];
	}

}
