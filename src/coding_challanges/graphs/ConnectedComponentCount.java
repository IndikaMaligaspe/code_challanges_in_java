package coding_challanges.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Indika
 *
 * We will need to find the count of connected components
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

public class ConnectedComponentCount {
//	Create an adjecent List
	static Map<Integer,ArrayList<Integer>> graph = Stream.of(new Object[][] {
		{0,new ArrayList<Integer>(Arrays.asList(8,1,5))},
		{1,new ArrayList<Integer>(Arrays.asList(0))},
		{5,new ArrayList<Integer>(Arrays.asList(0,8))},
		{8,new ArrayList<Integer>(Arrays.asList(0,5))},
		{2,new ArrayList<Integer>(Arrays.asList(3,4))},
		{3,new ArrayList<Integer>(Arrays.asList(2,4))},
		{4,new ArrayList<Integer>(Arrays.asList(3,2))},
		}).collect(Collectors.toMap(data -> (Integer) data[0], data -> (ArrayList<Integer>) data[1]));
	
	public static int countConnectedComponents(Map <Integer, ArrayList<Integer>> graph) {
		Set<Integer> visited = new HashSet<Integer>();
		int count = 0;
		//		Traverse through the vertices
		for(Integer key: graph.keySet()) {
			if(_countCompnentsHelper(graph, key, visited)) {
				count++;
			}
				
		}
		return count;
	}
	
	private static boolean _countCompnentsHelper(Map<Integer,ArrayList<Integer>> graph, int current, Set<Integer> visited) {
		if (visited.contains(current)) 
			return false;
		
		visited.add(current);
		for(Integer neighbor: graph.get(current)) {
			 _countCompnentsHelper(graph, neighbor, visited);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(countConnectedComponents(graph));
	}
}
