package self.preparation.matrix;

public class SearchInSortedMatrix {

	public static void main(String[] args) {

		int[][] mat = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 },
				        { 27, 29, 37, 48 }, 
				        { 32, 33, 39, 50 } 
				      };

		int key = 29;
		int n = mat.length;
		int i = 0, j = n - 1;
		while (i < n && j >= 0) {
			if (mat[i][j] == key) {
				System.out.println("item found at " + mat[i][j]);
				break;
			} else if (mat[i][j] > key) {
				j--;
			} else {
				i++;
			}
		}
	}

}
