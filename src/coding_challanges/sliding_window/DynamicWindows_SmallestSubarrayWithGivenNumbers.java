package coding_challanges.sliding_window;
/*
 * Given and array , find the smallest subarray with sum of k
 * i.e.
 * arr = [4,2,2,7,8,1,2,8,1,0]
 * k = 8
 * 
 */

public class DynamicWindows_SmallestSubarrayWithGivenNumbers {
	public static int findSmallaestSubArray(int[] arr, int k) {
		int smallastSubArray = Integer.MAX_VALUE;
		int windowStart = 0;
		int currentSum = 0;
		
		for (int i = 0; i <= arr.length  ; i++) {
			
			currentSum += arr[i];
			while(currentSum >= k) {
				smallastSubArray = Math.min(smallastSubArray, (i - windowStart) +1 );
				if(smallastSubArray == 1)
					return smallastSubArray;
				currentSum -= arr[windowStart];
				windowStart +=1;
			}
		}
		return smallastSubArray;
	}
	
	public static void main(String[] args) {
		System.out.println(findSmallaestSubArray(new int[] {4,2,2,7,1,8,2,5,1,0}, 8));
	}
}
