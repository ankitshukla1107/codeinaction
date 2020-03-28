
public class MaxProduct {

//{1,-4,3,-6,7,0}
//	
//	a = 7,b=3,c=1-->max elements 
//	d = -6, e=-4 --> min elements
//	
//	max(a,b,c) --- product (d,e)==-6*-4=24
//	24*7=168

	public static void main(String[] args) {
		int arr[] = { 1, -4, 3, -6, 7, 0 };
		int max = maxProduct(arr, arr.length);
		if (max == -1) {
			System.out.println("No three elements exists having max product");
		} else {
			System.out.println("Max product is: " + max);
		}

	}

	static int maxProduct(int arr[], int n) {
		if (n < 3)
			return -1;

		int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
		int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] > maxA) {
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			} else if (arr[i] > maxB) {
				maxC = maxB;
				maxB = arr[i];
			} else if (arr[i] > maxC) {
				maxC = arr[i];
			}

			if (arr[i] < minA) {
				minB = minA;
				minA = arr[i];
			} else if (arr[i] < minB) {
				minB = arr[i];
			}
		}
		return Math.max(minA * minB * maxA, maxA * maxB * maxC);
	}
}


//{1,-4,3,-6,7,0}
//
//a = 7,b=3,c=1-->max elements 
//d = -6, e=-4 --> min elements
//
//max(a,b,c) --- product (d,e)==-6*-4=24
//24*7=168