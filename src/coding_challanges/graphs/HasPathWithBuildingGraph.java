package coding_challanges.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/***
 * 
 * @author Indika
 *
 * In this has path we have to build a simple adjency list as well.
 * Also using a Set to track cyclic behavior
 * Given
 *  data = [
 * 	['i','j'],
 * 	['k','i'],
 * 	['m','k'],
 * 	['k','l'],
 * 	['o','n'],
 * ]
 * adjeceny graph would
 * 
 *  {
 *    "i":["j","k"],
 *    "j":["i"],
 *    "k":["i","m","l"],
 *    "l":["k"],
 *    "m":["k"],
 *    "o":["n"],
 *    "n":["o"],
 *  }
 *  
 *  hasPath using recursion and call stack
 */

public class HasPathWithBuildingGraph {
	static Set<String> visited = new HashSet<>(); 
	static String[][] data = 	{
							{"i","j"},
							{"k","i"},
							{"m","k"},
							{"k","l"},
							{"o","n"}
						}; 
	public static Map<String, ArrayList<String>> buildAdjencyGraph(String[][] data) {
		Map<String, ArrayList<String>> adMap = new HashMap<>();
		
		for (String[] vertex: data) {
			
			String a = vertex[0];
			String b = vertex[1];
			if(!adMap.containsKey(a)) 
				adMap.put(a, new ArrayList<String>());
			if(!adMap.containsKey(b)) 
				adMap.put(b, new ArrayList<String>());
			
			ArrayList<String> c = adMap.get(a);
			c.add(b);
			adMap.put(a,c);
			ArrayList<String> d = adMap.get(b);
			d.add(a);
			adMap.put(b,d);
			
		}
		return adMap;
	}
	
	public static boolean hasPath(Map<String, ArrayList<String>> graph, String src, String dst) {
		if(src == dst) return true;
		if(visited.contains(src)) return false;
		visited.add(src);
		ArrayList<String> elems = (ArrayList <String>) graph.get(src);
		for (String elem: elems) {
			if (hasPath(graph, elem,  dst)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Map<String, ArrayList<String>> graph = HasPathWithBuildingGraph.buildAdjencyGraph(data); 
		if(HasPathWithBuildingGraph.hasPath(graph, "j", "l")) {
			System.out.println("Path Available");
		} else {
			System.out.println("No Path Available");
		}
	}
}
