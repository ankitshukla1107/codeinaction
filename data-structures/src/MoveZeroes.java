
public class MoveZeroes {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,0,0,6,7};
	}
	
	private static void shiftZeros(int arr[]) {
		int counter = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				arr[counter++] = arr[i];
			}
		}
		
		while(counter<arr.length) {
			arr[counter++] = 0;
		}
	}
}
