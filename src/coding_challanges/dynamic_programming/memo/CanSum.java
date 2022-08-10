package coding_challanges.dynamic_programming.memo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author Indika
 * Return true or false, depedning on whether there is a way to sum up a given number
 * i.e.
 * given number 7, are there any numbers in the array [5,4,4,7] that can be sum up to produce 7
 * given number n, array m are there any numbers in m, that can be sum up to produce n
 * 
 */
public class CanSum {

	public static boolean canSum(Integer targetSum, int [] numbers) {
		if(numbers.length == 0) return false;
		Map<Integer, Boolean> memo = new HashMap<>();
		return (CanSum.explore(targetSum, numbers, memo));
		
	}
	
	private static boolean explore(Integer targetSum, int [] numbers, Map<Integer, Boolean> memo) {
		if(memo.containsKey(targetSum)) return (Boolean)memo.get(targetSum);
		if (targetSum == 0) return true;
		if (targetSum < 0) return false;
		

		for(int num: numbers) {
			int target = targetSum-num;
			if(CanSum.explore(target,numbers, memo)) {
				memo.put(targetSum, true);
				return true;
			}
		}
		memo.put(targetSum, false);
		return false;
	}
	
	public static void main(String[] args) {
		assert true == CanSum.canSum(7, new int[] {5,3,4,7}): "error";
		assert true == CanSum.canSum(7, new int[] {2,3}): "error";
		assert false == CanSum.canSum(7, new int[] {2,4}): "error";
		assert false == CanSum.canSum(300, new int[] {7,14}): "error";
		System.out.println("Passed");
	}
}
