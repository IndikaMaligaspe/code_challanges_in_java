package codility;

public class PassingCars {
	
	public static int sumPrefix(int[] P, int lp, int rp) {
		return P[rp + 1] - P[lp];
	}
	
	public static int solution(int [] A) {
		long maxPassing = 0;
		int l = A.length;
		int[] surf = new int[l + 1 ];
		
		for (int i=1;i < l ; i++) {
			int a = l - i;
			surf[a] = A[a] + surf[a + 1];
		}
		
		for(int i = 0; i< l;i++) {
			if(A[i] == 0)
				maxPassing += surf[i +1];	
		}
		if(maxPassing > 1000000000 )
			return -1;
		
		return (int)maxPassing;
	}
	
	public static void main(String[] args) {
		System.out.println(PassingCars.solution(new int[] {0,1,0,1,1}));
		System.out.println(PassingCars.solution(new int[] {0,1,0,1,0}));
		System.out.println(PassingCars.solution(new int[] {0}));
		System.out.println(PassingCars.solution(new int[] {1}));
		System.out.println(PassingCars.solution(new int[] {1 , 1, 1, 1}));
		System.out.println(PassingCars.solution(new int[] {0 , 0, 0, 0}));
		System.out.println(PassingCars.solution(new int[] {1 , 1, 0, 1}));
	}
}
