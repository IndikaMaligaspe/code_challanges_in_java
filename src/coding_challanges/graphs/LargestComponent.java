package coding_challanges.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Indika
 *
 * We will need to find the the largest component in the graph, return the size of the component with the most nodes
 * i.e.
 *  {
 *  	0:[8,1,5],
 *  	1:[0],
 *  	5:[0,8],
 *  	8:[0,5],
 *  	2:[3,4],
 *  	3:[2,4],
 *  	4:[3,2]
 *  } -> 2
 */ 
public class LargestComponent {
	static Map<Integer, ArrayList<Integer>> graph = Stream.of(new Object [][] {
		{0,new ArrayList<Integer>(Arrays.asList(8,1,5))},
		{1,new ArrayList<Integer>(Arrays.asList(0))},
		{5,new ArrayList<Integer>(Arrays.asList(0,8))},
		{8,new ArrayList<Integer>(Arrays.asList(0,5))},
		{2,new ArrayList<Integer>(Arrays.asList(3,4))},
		{3,new ArrayList<Integer>(Arrays.asList(2,4))},
		{4,new ArrayList<Integer>(Arrays.asList(3,2))},		
	}).collect(Collectors.toMap(data-> (Integer) data[0], data->(ArrayList<Integer>) data[1]));
	
	
	public static int componenatScan(Map<Integer, ArrayList<Integer>> graph) {
		Integer count = 0;
		int max = 0;
		Set<Integer> visited = new HashSet<Integer>();
		for (Integer key : graph.keySet()) {
			count  = scanner(graph, key, visited,count);
			if(count > max) {
				max = count;
				count=0;
			}
					
			
		}
		return max;
	}
	
	
	private static Integer scanner(Map<Integer, ArrayList<Integer>> graph, Integer current, Set visited, Integer count) {
		if(visited.contains(current)) return count;
		count+=1;
		visited.add(current);
		for(Integer neighbours : graph.get(current)) {
			count = scanner(graph, neighbours, visited, count);
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(graph.toString());
		System.out.println("Maximum components element count -> "+componenatScan(graph));
	}
}
