
public class WallmartTest {

	// sorted array---repition in array
	// write a function which takes integer
	// o/p--> first and last occurence of integer
	// O(logn)

	// 1, 2, 2, 3, 4, 5, 6, 7
	// i/p: 2
	// o/p: 1, 2

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 5, 6, 7 };
		int arr1[] = {1,1,1,2,2,2,2,5,6,7};
		int firstOccurance = getFirstOccuranceint(arr1, 0, arr1.length - 1, 2, arr1.length);
		System.out.println("frst occ:" + firstOccurance);
	}

	private static int getFirstOccuranceint(int arr[], int low, int high, int key, int n) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || key > arr[mid - 1]) && arr[mid] == key)
				return mid;
			else if (key > arr[mid])
				return getFirstOccuranceint(arr, mid + 1, high, key, n);
			else
				return getFirstOccuranceint(arr, low, mid - 1, key, n);
		}
		return -1;

	}

}
