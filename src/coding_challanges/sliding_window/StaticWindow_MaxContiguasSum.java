package coding_challanges.sliding_window;

import java.lang.module.FindException;

/*
 * Find the max sum subarray of a fixed size k
 * 
 * Example 
 * arr = [4,2,1,7,8,1,2,8,1,0]
 * k = 3
 */


public class StaticWindow_MaxContiguasSum {
	
	public static int findMaxSubArray(int[] arr, int k) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for (int i = 0; i <arr.length ; i++) {
			currentSum += arr[i];
			if( i >= k - 1 ) {
				if (maxSum < currentSum)
					maxSum = Math.max(maxSum, currentSum);
				currentSum -= arr[i - (k - 1)]; 
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxSubArray(new int[] {4,2,1,7,8,1,2,8,1,0}, 3));
	}
}
