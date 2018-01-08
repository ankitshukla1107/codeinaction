package self.preparation.array;

//asked in amazon

public class NumberOccuringOddTimes {

	public static void main(String[] args) {
	//	int arr[] = {1, 5, 7, 3, 5 , 3 ,3};
		int arr[] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result^arr[i];
		}
		System.out.println(result);
	}

}
