package coding_challanges.dynamic_programming.memo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author Indika
 *
 *	There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 *	The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 *	The robot can only move either down or right at any point in time.	
 *	Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *	The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *  m=3, n=7
 */
public class GridTraveler {
	public static int countPath(int m, int n) {
		int count = 0;
		if(m==0 || n==0) return 0;
		Map<String, Integer> visited = new HashMap<>();	
		count = GridTraveler.explore(m,n, visited);
		return count;
	}
	
	private static int explore(int r, int c, Map<String, Integer> visited) {
		if (r == 1 && c == 1) return 1;
		if( r == 0 || c == 0) return 0;
		String pos = r+","+c;
		int cc = explore(r-1,c, visited) + explore(r,c-1, visited);
		visited.put(pos, cc);
		if(visited.containsKey(pos)) return visited.get(pos);
		return (visited.get(pos));
	}
	public static void main(String[] args) {
		assert 0 == GridTraveler.countPath(3, 0): "3,0 error";
		assert 1 == GridTraveler.countPath(1, 1): "1,1 error";
		assert 6 == GridTraveler.countPath(3, 3): "3,3 error";
		System.out.println("SUCCESS");
	}
}
