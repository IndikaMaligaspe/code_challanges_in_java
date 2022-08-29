package coding_challanges.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Given and array , find the longest subarray with distinct k character
 * i.e.
 * arr = [A,A,A,H,H,I,B,C]
 * k = 3
 * 
 */

public class DynamicWithExternalStructure_LongerSubstringLengthWithDistictCharacters {

	public static int LongerSubstringLength(char[] arr, int k) {
		int longestLength = Integer.MIN_VALUE;
		int currentLength = 0;
		int windowStart = 0;
		
		if(arr.length == 1)
			return 1;
		
		if(arr.length == 0)
			return 0;
		
		Map<String, Integer> wordCount = new ConcurrentHashMap<>();
		
		for(int windowEnd = 0; windowEnd< arr.length; windowEnd++ ) {
			
			Integer count = wordCount.get(String.valueOf(arr[windowEnd]))==null
						?0
						: wordCount.get(String.valueOf(arr[windowEnd]));
			wordCount.put(String.valueOf(arr[windowEnd]), count +=1);
			currentLength +=1;
			while(wordCount.size() >= k) {
				 count = wordCount.get(String.valueOf(arr[windowStart]));
				 count -=1;
				 if(count == 0) {
					 wordCount.remove(String.valueOf(arr[windowStart]));
				 } else {
					 wordCount.put(String.valueOf(arr[windowStart]), count);
				 }
				 windowStart ++;
				 currentLength --;	 
				
			}
			longestLength = Math.max(longestLength, currentLength);
		}
		return longestLength;
	}
	
	public static void main(String[] args) {
		System.out.println(LongerSubstringLength(new char[] {'A','A','A','H','H','I','B','C'}, 3));
		System.out.println(LongerSubstringLength(new char[] {'I','A','A','H','H','I','B','C'}, 3));
		System.out.println(LongerSubstringLength(new char[] {'I','K','A','H','I','I','C','C'}, 3));
		System.out.println(LongerSubstringLength(new char[] {'I'}, 3));
	}
}
