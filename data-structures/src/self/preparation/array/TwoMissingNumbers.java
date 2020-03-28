package self.preparation.array;

public class TwoMissingNumbers {

	public static void main(String[] args) {
		int input[] = new int[] {1,2,3,5};
		int result[] = getTwoMissing(input);
		for(int i:result) {
			System.out.println(i);
		}
	}
	
	public static int[] getTwoMissing(int[] arr) {
		int size = arr.length+2;
		long totalSum = size*(size+1)/2;
		long arrSum = 0;
		for(int i: arr) arrSum+=i;
		
		int pivot = (int)((totalSum-arrSum)/2);
		
		int totalLeftXor = 0;
		int arrLeftXor = 0;
		int totalrightXor = 0;
		int arrRightXor = 0;
		
		for(int i=1;i<=pivot;i++) totalLeftXor ^= i;
		for(int i=pivot+1;i<=size;i++) totalrightXor ^=i;
		
		for(int current:arr) {
			if(current<=pivot) {
				arrLeftXor^=current;
			}else {
				arrRightXor^=current;
			}
		}
		
		return new int[] {
			totalLeftXor^arrLeftXor, totalrightXor^arrRightXor
		};
	}

}
