package coding_challanges.dynamic_programming.tabular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/***
 *  Identify if a subset of array elements can sum up to a given number
 *  
 *  i.e.
 *  give an array of n elements (integer non negative) and an integer k
 *  find out if a subset of elements in the array can sum up to k
 *  
 *  If an array {3,5,4, 2} and 7 is give, is there a subset in the array that can sum up to 7
 *  the answer is T, [{3,4}, {5,2}, {3,2,2}]  can sum up to 7
 *  Note: - 
 *  	all numbers are positive integers
 *  	number can repeat
 *  
 *  
 *  Using Tabulation
 * 
 */

public class HowSum {

public static ArrayList<Integer> howSum(int[] arr, int sum) {
		
//		create a 2D array to store the results, rows = sum, cols = arr elements
		
		List<ArrayList<Integer>>  table = new ArrayList<ArrayList<Integer>>(sum + 1);
		for(int i =0; i < sum+1; i++) {
			table.add(null);
		}
		table.set(0,new ArrayList<Integer>());		
		
		for (int i = 0; i< table.size(); i ++) {
			for (int j= 0; j< arr.length; j++) {
				if(table.get(i) != null) {
					if(i + arr[j] >= table.size())
						continue;
					var tArr = new ArrayList<Integer>(table.get(i));
					tArr.add(arr[j]);
					table.set(i+arr[j], tArr);
//					var tArr = table.get(i+arr[j]);
//					if(tArr == null) {
//						ArrayList<Integer> temp = new ArrayList<Integer>(); 
//						temp.add(arr[j]);
//						if(i + arr[j] <= table.size())
//							table.set(i + arr[j], temp);
//					} else {
//						ArrayList<Integer> temp = table.get(i+arr[j]);
//							temp.add(arr[j]);
//					}
				}
			}
		}
		System.out.println("----------The complete 2D array after filling, only for reading purpose-------------------------");
		System.out.println(table);
		return table.get(sum);
	}

	public static void main(String[] args) {
//		System.out.println(HowSum.howSum(new int [] {2,3}, 7));
//		System.out.println(HowSum.howSum(new int [] {5,3,4,7}, 7));
		System.out.println(HowSum.howSum(new int [] {2,3,5}, 8));
//		System.out.println(HowSum.howSum(new int [] {2,4}, 7));
	}
}
