package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDoubleSliceSum {
	public static Integer solution(int[] A) {
		  int maxSlice = Integer.MIN_VALUE;
		  int[] start = new int[A.length];
		  int[] end = new int[A.length];
		  
		  for (int i =1; i< A.length -1; i++) {
			  int flSum = A[i] + start[i-1];
			  int rlSum = A[A.length - (i+1)] + end[A.length - (i)];
			  start[i] = flSum > 0? flSum : 0; 
			  end[A.length -(i+1)] = rlSum > 0 ? rlSum : 0; 
		  }
		  for(int i =1; i < A.length -1 ; i++ ) {
			  maxSlice = Math.max(start[i-1] + end[i+1], maxSlice);
		  }
		  return maxSlice;	
	}

	
	
	public static void main(String[] args) {
		System.out.println(MaxDoubleSliceSum.solution(new int[] {3,2,6,-1,4,5,-1,2}));
	}
}
