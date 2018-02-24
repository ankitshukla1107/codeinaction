package self.preparation.array;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] a = { 2, 5, 0, 6, 0, 0, 7, 0, 0 };
		int[] result = moveZerosToEnd(a);
		for (int i : result) {
			System.out.println(i);
		}
	}

	private static int[] moveZerosToEnd(int[] arr) {
		int i = 0, j = 0;
		while (i < arr.length) {
			if (arr[i] != 0) {
				arr[j++] = arr[i];
			}
			i++;
		}
		while (j < arr.length) {
			arr[j++] = 0;
		}
		return arr;
	}

}
