package codility;

import java.util.HashSet;
import java.util.Set;

/*
 * Write a function

	class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns the number of distinct values in array A.

	For example, given array A consisting of six elements such that:

	 A[0] = 2    A[1] = 1    A[2] = 1
	 A[3] = 2    A[4] = 3    A[5] = 1
	the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

	Write an efficient algorithm for the following assumptions:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [−1,000,000..1,000,000].
*/


public class DistinctElemnets {
	
	public static void mergeSort(int[] A) {
		
		if(A == null)
			return;
		if(A.length > 1)
        {
			int mid = A.length /2;
			int[] leftArr = new int[mid];
			for(int i =0 ; i <mid; i++) {
				leftArr[i] = A[i];
			}
			
			int[] rightArr = new int[A.length - mid];
			for(int i =mid ; i <A.length; i++) {
				rightArr[i - mid] = A[i];
			}
			
			
			DistinctElemnets.mergeSort(leftArr);
			DistinctElemnets.mergeSort(rightArr);
			
			int i = 0;
			int j = 0;
			int k = 0;
			while (i < leftArr.length && j < rightArr.length) {
				if(leftArr[i] < rightArr[j]) {
					A[k] = leftArr[i];
					i++;
				} else {
					A[k] = rightArr[j];
					j++;
				
				}
				k++;
			}
			
			while(i < leftArr.length) {
				A[k] = leftArr[i];
                i++;
                k++;
			}
			while(j < rightArr.length)
            {
                A[k] = rightArr[j];
                j++;
                k++;
            }
        }
			
	}
	
	public static int solutionSort(int[] A) {
		int distinctElements = 1;
		int elements = 0;
		if(A.length == 0)
			return 0;
		
//		Sort the array (will use merge sort, but can just use Arrays.sort as well)
		DistinctElemnets.mergeSort(A);
		
//		Find distinct groups
		elements = A[0];
		for (int i =0;i< A.length; i++) {
			if(elements != A[i]) {
				distinctElements+=1;
				elements = A[i];
			}
				
		}
		return distinctElements;
	}
	
	public static int solutionNoSort(int A[]) {
		if(A.length == 0)
			return 0;
		
		Set<Integer> hset = new HashSet<>();
		
		for (int i =0;i< A.length; i++) {
			if(!hset.contains(A[i])) {
				hset.add(A[i]);
			}
				
		}
		return hset.size();
	}
	public static void main(String[] args) {
		System.out.println(DistinctElemnets.solutionSort(new int[] {2,1,1,2,3,1}));
		System.out.println(DistinctElemnets.solutionSort(new int[] {2,-1,1,2,3,1}));
		System.out.println(DistinctElemnets.solutionSort(new int[] {-1,-1,-1}));
		System.out.println(DistinctElemnets.solutionSort(new int[] {}));
		
		System.out.println(DistinctElemnets.solutionNoSort(new int[] {2,1,1,2,3,1}));
		System.out.println(DistinctElemnets.solutionNoSort(new int[] {2,-1,1,2,3,1}));
		System.out.println(DistinctElemnets.solutionNoSort(new int[] {-1,-1,-1}));
		System.out.println(DistinctElemnets.solutionNoSort(new int[] {}));
	}
}
