package coding_challanges.dynamic_programming.tabular;

import java.util.Arrays;

/**
 * 
 * @author Indika
 *
 *  calculate Fibonacci using tabular pattern
 *  
 *  Given a number 'n', find the fibonacci of that number
 */

public class Fibonacci {

	private static long fib(int num) {
		
		long[] nArr = new long[num + 1];
		Arrays.fill(nArr, 0);
		nArr[1] = 1;
		for (int n =0;  n <= nArr.length; n ++) {
			if(n + 1 < nArr.length)
				nArr[n+1] += nArr[n];
			if(n + 2 < nArr.length)
				nArr[n+2] += nArr[n];
		}
		return nArr[num];		
	}

	
	public static void main(String[] args) {
		System.out.println(Fibonacci.fib(50));
	}
}
