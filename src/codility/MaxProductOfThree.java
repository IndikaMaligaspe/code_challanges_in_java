package codility;

import java.util.Arrays;

public class MaxProductOfThree {
	
	public static int solution(int[] A) {
		int minProduct = Integer.MIN_VALUE;
		int maxProduct = Integer.MAX_VALUE;
		
		Arrays.sort(A);
//		Need to do this as there could be negative values and the product of 2 negative values will be a positive
		if(A[0] < 0 && A[1] < 0) {
			minProduct = A[0] * A[1] * A[A.length -1];
		}
		
		maxProduct = A[A.length -1] * A[A.length -2] * A[A.length -3];
		
		return Math.max(minProduct, maxProduct);
	}
	
	public static void main(String[] args) {
		System.out.println(MaxProductOfThree.solution(new int[] {-3,1,2,-2,5,6}));
		System.out.println(MaxProductOfThree.solution(new int[] {-5,5,-5,4}));
	}
}
