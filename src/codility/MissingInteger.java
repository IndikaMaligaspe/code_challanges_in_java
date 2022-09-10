package codility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class MissingInteger {
	public static int solution_java_map(int[] A) {
			int minInt = 1;
			Map<Integer, Integer> counts = new HashMap<>();
			for(int a:A) {
				if(!counts.containsKey(a + 1)) 
						counts.put(a + 1 , 0);
				if(!counts.containsKey(a - 1)) 
					counts.put(a - 1 , 0);
				
				counts.put(a  , 1);	
			}
		
			if(!counts.containsKey(1))
				return 1;
			
			Optional<Entry<Integer, Integer>> opt  = counts.entrySet()
			.stream()
			.filter(e -> e.getValue().equals(0) && e.getKey() > 0)
			.min(Comparator.comparing(e->e.getValue()));
			
			if(opt.isPresent())
				minInt = opt.get().getKey();
			
			
		return minInt;
	}
	
	public static int solution_java_hashset(int[] A) {
		HashSet<Integer> hset = new HashSet<>();
				
		for(int i =1;i<= A.length+1; i++) {
			hset.add(i);
		}
		
		for(int a: A) {
			hset.remove(new Integer(a));
		}
		return hset.iterator().next();
	}
	
	
	public static void main(String[] args) {
//		System.out.println(MissingInteger.solution_java_map(new int[] {1,3,6,4,1,2}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {1,2,3}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {90, 91, 92, 93}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {-1,-2}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {1}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {0}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {2}));
//		System.out.println(MissingInteger.solution_java_map(new int[] {-1000000, 1000000}));
		
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {1,3,6,4,1,2}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {1,2,3}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {90, 91, 92, 93}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {-1,-2}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {1}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {0}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {2}));
//		System.out.println(MissingInteger.solution_java_hashset(new int[] {-1000000, 1000000}));
		

	}
}
