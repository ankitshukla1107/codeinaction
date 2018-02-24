package self.preparation.array;

public class SumClosestToZero {

	public static void main(String[] args) {
		int arr[] = {1,60,-10,70,-80,85};
		int min_sum = arr[0]+arr[1];
		int sum, min_i = 0, min_j = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length; j++) {
				sum = arr[i]+arr[j];
				if(Math.abs(sum)<Math.abs(min_sum)){
					min_sum = sum;
					min_i = i;
					min_j = j;
				}
			}
		}
		System.out.println("sum closest to zero is: "+min_sum+ " and elements are: "+ arr[min_i]+" and "+ arr[min_j]);
	}

}
