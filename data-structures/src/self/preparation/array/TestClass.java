package self.preparation.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TestClass {

	    
		public static void main(String[] args) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(1, null);
			map.put(null, null);
			map.put(null, 3);
			for(Map.Entry<Integer, Integer> entry: map.entrySet()){
				System.out.println(entry.getKey()+""+entry.getValue());
			}
			Scanner sc = new Scanner(System.in);
			int testCases = sc.nextInt();
			int arr[];
			while(testCases>0){
				int inputs = sc.nextInt();
				if(inputs>0){
					arr = new int[inputs];
					for(int i=0; i< inputs; i++){
						arr[i] = sc.nextInt();
					}
					getMaxContiguousSubArraySum(arr);
				}
				testCases--;
			}
			sc.close();
		}


		public static void getMaxContiguousSubArraySum(int[] arr) {
			int[] result = new int[2];
			int contSum = arr[0];
			int prevContSum = arr[0];
			int nonContSum = arr[0];
			int n = arr.length;

			for (int i = 1; i < n; i++) {
				if (contSum < 0 && arr[i] >= 0) {
					contSum = arr[i];
				} else {
					contSum += arr[i];
				}
				if (nonContSum < 0 && arr[i] >= 0) {
					nonContSum = arr[i];
				} else if (nonContSum + arr[i] > nonContSum) {
					nonContSum += arr[i];
				} else if (nonContSum < arr[i] && nonContSum + arr[i] < nonContSum) {
					nonContSum = arr[i];
				}
				if (contSum >= prevContSum) {
					prevContSum = contSum;
				} else if (contSum < 0) {
					contSum = arr[i];
				}
			}

			result[0] = contSum > prevContSum ? contSum : prevContSum;
			result[1] = nonContSum;
			System.out.println(result[0]+" "+result[1]);
		}
	}