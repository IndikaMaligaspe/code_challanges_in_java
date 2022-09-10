package codility;

public class MushroomPicker {
	public static int sumPrefix(int[] P, int lp, int rp) {
		return P[rp + 1] - P[lp];
	}
	
	public static int solution(int[] A, int k, int m) {
		int maxMushrooms = 0;
		int length = A.length;
//		get prefix sum
		int[] pref = new int[length + 1 ];
		for (int i=1;i < length + 1 ; i++) {
			pref[i] = A[i - 1] + pref[i - 1];
		}
		
		for(int i=1; i< Math.min(m, k)+1; i++) {
			int lp = k-i;
			int x = k + m - 2 * i;
			int rp = Math.min(length-1, Math.max(k,x));
			int sum = MushroomPicker.sumPrefix(pref, lp, rp);
			maxMushrooms = Math.max(maxMushrooms, sum);
		}
		
//		for num in xrange(a, b) is equivalent to
//		for (int num=a+1; num < 2*a+1; num++) {...}
//		
		for(int i=1; i< Math.min(m + 1 , length - k); i++) {
			int rp = k + i;
			int x = k - (m - 2 * i);
			int lp = Math.max(0, Math.min(k,x));
			int sum = MushroomPicker.sumPrefix(pref, lp, rp);
			maxMushrooms = Math.max(maxMushrooms, sum);
		}
		
		return maxMushrooms;
	}
	public static void main(String[] args) {
		System.out.println(MushroomPicker.solution(new int[] {2,3,7,5,1,3,9}, 4, 6));
	}
}
