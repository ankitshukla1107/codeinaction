package self.preparation.array;

public class Searching {

	public static void main(String[] args) {
		int arr[] = {2,5,7,9,11};
		System.out.println(Searching.iterativeBinarySearch(arr, arr.length, 10));
		System.out.println(Searching.recursiveBinarySearch(arr, 5, 0, 4));
	}
	
	public static int iterativeBinarySearch(int arr[], int size, int item){
		int low = 0, high = size-1, mid;
		while(low<=high){
			mid = low + (high-low)/2;
			if(item==arr[mid]){
				System.out.println("item found at "+mid+" location for iterative search");
				return mid;
			}else if(item<arr[mid]){
				high = mid-1;
			}else {
				low = mid+1;
			}			
		}
		return -1;
	}
	
	private static int recursiveBinarySearch(int arr[], int item, int low, int high){
		int mid = low+(high-low)/2;
		if(item==arr[mid]){
			System.out.println("item found at "+mid+" location for recursive search");
			return mid;
		}else if(item<arr[mid]){
			return recursiveBinarySearch(arr, item, low, mid-1);
		}else if(item>arr[mid]){
			return recursiveBinarySearch(arr, item, mid+1, high);
		}else{
			System.out.println("item not found");
		}
		return -1;
	}

}
