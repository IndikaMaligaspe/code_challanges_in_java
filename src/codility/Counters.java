package codility;

import java.util.Arrays;

public class Counters {
	public static int[] solution(int N, int[] A) {
		int [] arr = new int[N];
		int counter = 0;
		int maxCount = 0;
		int minCount = 0;
		for(int a: A) {
			if(a <= N) {
				counter = arr[a - 1] + 1;
				arr[a - 1] = Math.max(minCount + 1, counter);
				maxCount = Math.max(arr[a - 1], maxCount);
			} else if (a == N+1) {
				minCount = maxCount;
			}
				
		}
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] < minCount)
				arr[i] = minCount;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = Counters.solution(5, new int[] {3,4,4,6,1,4,4} );
		
		for(int a: arr) {
			System.out.print(a+",");
		}
	}
}
