package coding_challanges.dynamic_programming.tabular;

import java.util.Arrays;

/***
 *  Identify if a subset of array elements can sum up to a given number
 *  
 *  i.e.
 *  give an array of n elements (integer non negative) and an integer k
 *  find out if a subset of elements in the array can sum up to k
 *  
 *  If an array {3,5,4} and 7 is give, is there a subset in the array that can sum up to 7
 *  the answer is T, 3+4 or 4+3 can sum up to 7
 *  
 *  Using Tabulation
 * 
 */
public class CanSum {
	public static long canSum(int[] arr, int sum) {
		
//		create a 2D array to store the results, rows = sum, cols = arr elements
		
		long [][] table = new long[arr.length + 1][sum + 1];
		for(long[] t : table) {
			Arrays.fill(t, 0);
			t[0] = 1;
		}
		
		for(int i = 1; i < table.length; i++) {
			for( int j = i; j < table[i].length; j++) {
				if (table[i -1][j] == 1) {
					table[i][j] = 1;
				} else if(j % arr[i-1] == 0){         //Note that modules makes the number repeatable
					table[i][j] = 1;                  // If we do not want to repeat use if( j == arr[i-1]) 
				} else if(j >= arr[i-1]){
					table[i][j] = table[i - 1][j - arr[i-1]];
				}
			}
		}
		System.out.println("----------The complete 2D array after filling, only for reading purpose-------------------------");
		for(int i = 0; i < table.length; i++) {
			for( int j = 0; j < table[i].length; j++) {
				System.out.print("["+table[i][j]+"]");
			}
			System.out.println();
		}
		return table[arr.length][sum];
	}
	

	
	public static void main(String[] args) {
		System.out.println(CanSum.canSum(new int [] {2,3}, 7));
		System.out.println(CanSum.canSum(new int [] {5,3,4,7}, 7));
		System.out.println(CanSum.canSum(new int [] {2,3,5}, 8));
		System.out.println(CanSum.canSum(new int [] {2,4}, 7));
	}
}
