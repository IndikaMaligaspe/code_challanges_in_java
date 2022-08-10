package coding_challanges.dynamic_programming.memo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList <List<Integer>> result = new ArrayList();
		CombinationSum.combinationSumHelper(candidates, 0, target,new ArrayList(),result);
		return result;
    }
	
	private static void combinationSumHelper(
			int[] candidates,
			int start,
			int target,
			List list, 
			List result) {
		if(target == 0) {
			result.add(new ArrayList(list));
		}
		if(target < 0 ) {
			return;
		}
		
		for (int i=start;i < candidates.length; i ++) {
			list.add(candidates[i]);
			int remainderTarget = target - candidates[i];
			combinationSumHelper(candidates, i, remainderTarget, list, result);
			list.remove(list.size() -1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(CombinationSum.combinationSum(new int[] {2,3,5}, 8));
	}
}
