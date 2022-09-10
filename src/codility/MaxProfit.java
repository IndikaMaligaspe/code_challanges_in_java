package codility;

public class MaxProfit {
	public static int solution(int[] A) {
		long maxElement = Integer.MIN_VALUE;
		
		if (A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return A[0];
		}
		
		for(int i = 0;i < A.length; i++) {
			for(int j = i + 1; j < A.length; j++) {
				maxElement = Math.max(A[j] - A[i], maxElement);
			}
		}
		
		return (int)(maxElement < 0 ? 0: maxElement);
	}	
	
	public static int solutionB(int[] A) {
		int maxProfit = 0;
		int runningProfit = 0;
		
		
		for(int i = 1;i < A.length; i++) {
			int dailyProfit = A[i] - A[i -1];
			runningProfit += dailyProfit;
			if(runningProfit > 0) {
				if(runningProfit > maxProfit) {
					maxProfit = runningProfit;
				}
			} else {
				runningProfit = 0;
			}
		}
		
		return maxProfit;
	}	
	
	public static int solutionC(int[] A) {
		int maxProfit = 0;
		int runningProfit = 0;
		
		
		if(A.length == 0)
			return 0;
		
		int minBuy = A[0];
		
		
		for(int i = 1;i < A.length; i++) {
			if(A[i] < minBuy) {
				minBuy = A[i];
				runningProfit = 0;
			} else {
				runningProfit += A[i] - A[i -1];
			}
			if(maxProfit < runningProfit) {
				maxProfit = runningProfit;
			}
				
		}
		
		return maxProfit;
	}
	
	
	public static void main(String[] args) {
		System.out.println(MaxProfit.solutionB(new int[] {23171,21011,21123,21366,21013,21367}));
		System.out.println(MaxProfit.solutionC(new int[] {23171,21011,21123,21366,21013,21367}));
//		System.out.println(MaxProfit.solutionB(new int[] {5, 4, 3, 2, 1}));
	}
}
