package codility;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
	
	public static int[] solutionSimple(String S, int[] P, int[] Q) {
		int[] minFactor = new int[P.length];
		int[] imFact = new int[S.length()];
		Map<String, Integer> memo = new HashMap<String, Integer>();
//		Convert String in impact factor
		
		for(int i=0;i < S.length(); i++) {
			switch(S.charAt(i)) {
				case  'A' : imFact[i] = 1; break;
				case  'C' : imFact[i] = 2; break;
				case  'G' : imFact[i] = 3; break;
				case  'T' : imFact[i] = 4; break;
				default: break;
			}
		}
		

		for(int i = 0; i < P.length; i++) {
			int stSQ = P[i];
			int enSQ = Q[i];
			int minCounter = Integer.MAX_VALUE;
//			A memoization to optimize the solution
			if(memo.containsKey(stSQ+":"+enSQ)) {
				minFactor[i] = memo.get(stSQ+":"+enSQ);
			} else {
				for (int j = stSQ; j <= enSQ; j++) {
					minCounter = Math.min(minCounter, imFact[j]);
				}
				minFactor[i] = minCounter;
				memo.put(stSQ+":"+enSQ, minCounter);
			}
		}
		return minFactor;
	}
	
	public static int[] solutionPrefixSum(String S, int[] P, int[] Q) {
		int[] minFactor = new int[P.length];
		int[][] prefSum = new int[4][S.length()];
		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;
		
		for(int i=0;i < S.length(); i++) {
			switch(S.charAt(i)) {
				case  'A' : A +=1; break;
				case  'C' : C +=1; break;
				case  'G' : G +=1; break;
				case  'T' : T +=1; break;
				default: break;
			}
			prefSum[0][i] = A;
			prefSum[1][i] = C;
			prefSum[2][i] = G;
			prefSum[3][i] = T;
			
		}
		
		for(int i =0; i< P.length; i++) {
			int stSQ = P[i];
			int enSQ = Q[i];
			if(stSQ == enSQ) {
				if(S.charAt(stSQ) == 'A') {
					minFactor[i] = 1;
				} else if (S.charAt(stSQ) == 'C') {
					minFactor[i] = 2;
				} else if (S.charAt(stSQ) == 'G') {
					minFactor[i] = 3;
				} else if (S.charAt(stSQ) == 'T') {
					minFactor[i] = 4;
				}
			} else {
			
				if(prefSum[0][stSQ] != prefSum[0][enSQ] || S.charAt(stSQ) == 'A') {
					minFactor[i] = 1;
				} else if(prefSum[1][stSQ] != prefSum[1][enSQ] || S.charAt(stSQ) == 'C'){
					minFactor[i] = 2;
				} else if(prefSum[2][stSQ] != prefSum[2][enSQ] || S.charAt(stSQ) == 'G') {
					minFactor[i] = 3;
				} else if(prefSum[3][stSQ] != prefSum[3][enSQ]  || S.charAt(stSQ) == 'T') {
					minFactor[i] = 4;
				}
			}
		}
		
		
		return minFactor;
	}
	
	public static void main(String[] args) {
		int[] a = GenomicRangeQuery.solutionSimple("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6});
		for(int x: a) {
			System.out.print(x+",");
		}
		System.out.println();
		
		int[] a1 = GenomicRangeQuery.solutionSimple("AC", new int[] {0,0,1}, new int[] {0,1,1});
		
		for(int x: a1) {
			System.out.print(x+",");
		}
		System.out.println();
				
		int[] a2 = GenomicRangeQuery.solutionPrefixSum("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6});
		for(int x: a2) {
			System.out.print(x+",");
		}
		System.out.println();
		int[] a3 = GenomicRangeQuery.solutionPrefixSum("AC", new int[] {0,0,1}, new int[] {0,1,1});
		for(int x: a3) {
			System.out.print(x+",");
		}
		System.out.println();
		
	}
}
