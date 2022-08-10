package coding_challanges.dynamic_programming.memo;

import java.util.ArrayList;
import java.util.List;

public class BestSum {
	public static List<List<Integer>> bestSum(int[] candidates, int target) {
        ArrayList <List<Integer>> result = new ArrayList();
        BestSum.bestSumHelper(candidates, 0, target,new ArrayList(),result);
		return result;
    }
	
	private static void bestSumHelper(
			int[] candidates,
			int start,
			int target,
			List list, 
			List result) {
		if(target == 0) {
			if( (result.size() ==0)) {
				result.add(new ArrayList(list));
			} else if (((ArrayList) result.get(0)).size() > list.size()) {
				result.remove(0);
				result.add(new ArrayList(list));
			}
		}
		if(target < 0 ) {
			return;
		}
		
		for (int i=start;i < candidates.length; i ++) {
			list.add(candidates[i]);
			int remainderTarget = target - candidates[i];
			bestSumHelper(candidates, i, remainderTarget, list, result);
			list.remove(list.size() -1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(BestSum.bestSum(new int[] {2,3,5}, 8));
	}
	
}
