package coding_challanges.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/***
 * 
 * @author Indika
 *
 *  Fibonacci  seqaunce  looks like 1,1,2,3,5,7,13,...(n-2),(n-1)...
 *  The usual function that calcualtes Fibonacci has a time complaxity of O(2^n) time complexity
 *  We need to use memoization to reduce this complexity  
 *  Usually the 
 */
public class FibonacciSeqaunce {
	
//	public static long fibonacciUsual(int n) {
//		if (n < 0) return 0;
//		if(n == 1 || n ==0) return 1;
//		return fibonacciUsual(n-1)+fibonacciUsual(n-2);
//	}
	
//	using memoization
	
	public static long fibonaccBogO_n(int n) {
		if (n < 0) return 0;
		Map <Integer, Long> memo = new HashMap<>();
		return fibonacciHelper(n, memo);
	}
	
	private static long fibonacciHelper(int n, Map <Integer, Long> memo) {
		if(n==0 || n==1) return 1;
		if(memo.containsKey(n))return memo.get(n);
		
		long ret = fibonacciHelper(n-1, memo) + fibonacciHelper(n-2, memo);
		memo.put(n, ret);
		return ret;
	}
	
	public static void main(String[] args) {
		int n =50;
		System.out.println("Fubonacci of "+5+" = "+FibonacciSeqaunce.fibonaccBogO_n(n));
	}

}
