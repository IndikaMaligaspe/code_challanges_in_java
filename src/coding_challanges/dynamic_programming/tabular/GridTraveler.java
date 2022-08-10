package coding_challanges.dynamic_programming.tabular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	
	public static int gridTraveler(int m, int n) {

		int [][] table = new int[m+1][n+1];
		for (int [] row: table) {
			Arrays.fill(row, 0);
		}
		table[1][1] = 1;
		
		for(int i=0; i<= m;i++) {
			for(int j = 0; j <= n; j++) {
				int current = table[i][j];
				if(j + 1 <= n) table[i][j+1] += current;
				if(i + 1 <= m) table[i + 1][j] += current;
			}
		}
		return table[m][n];
	}
	
	public static void main(String[] args) {
		System.out.println(GridTraveler.gridTraveler(3, 3));
	}
}
