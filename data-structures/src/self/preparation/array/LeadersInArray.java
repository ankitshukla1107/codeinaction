package self.preparation.array;

public class LeadersInArray {

	public static void main(String[] args) {
		int[] arr = { 16, 17, 4, 3, 5, 2 };
		int max_from_right = arr[arr.length - 1];

		/* Rightmost element is always leader */
		System.out.print(max_from_right + " ");

		for (int i = arr.length - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				max_from_right = arr[i];
				System.out.print(max_from_right + " ");
			}
		}
	}
}
