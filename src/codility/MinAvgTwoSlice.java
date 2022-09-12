package codility;

public class MinAvgTwoSlice {

	public static int solution(int[] A) {
		double minAvg = Integer.MAX_VALUE;
		double minOfSlice = Integer.MAX_VALUE;
		int minStart = Integer.MAX_VALUE;
		double minOfThree = Integer.MAX_VALUE;
		double minOfTwo = Integer.MAX_VALUE;
		
//		Mathematically any slice which has more than a length of 4 will have 
//		sub slices which are having smaller averages. 
//		hence we need to check only for slices of 2 or 3 in length
//		So I will use a sliding window of 2 and 3 length
		int i = 0;
		while(i < A.length - 1 ) {
			 minOfTwo = (A[i] + A[i+1] ) / 2.0;
			 if(i < A.length -2) {
				 minOfThree = (A[i] + A[i+1] + A[i+2]) / 3.0;
			 }
			minOfSlice = Math.min(minOfThree, minOfTwo);
			if(minOfSlice < minAvg  ) {
				minAvg = minOfSlice;
				minStart = i;
			}
			i++;
		}

		return minStart;
	}
	public static void main(String[] args) {
		System.out.println(MinAvgTwoSlice.solution(new int[] {4,2,2,5,1,5,8}));
		System.out.println(MinAvgTwoSlice.solution(new int[] {4,2}));
		System.out.println(MinAvgTwoSlice.solution(new int[] {4,2,2,5,2,2,8}));
		System.out.println(MinAvgTwoSlice.solution(new int[] {4,2,2,5,-2,-2,8}));
	}
}
