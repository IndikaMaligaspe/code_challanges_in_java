package coding_challanges.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Indika
 *
 *  Need to find the shortest distance between two nodes 
 *  i.e.
 *  gieb edges 
 *  edges = [
 *  			["w","x"],
 *  			["x","y"],
 *  			["z","y"],
 *  			["z","v"],
 *  			["w","v"],
 *  		]
 *  the distance in the shortest path between "w" and "z" is 2  <w->y, y->z>
 */
public class ShortestPath {
//	generate the adjecentList
	static String[][] edges = {
									{"w","x"},
									{"x","y"},
									{"z","y"},
									{"z","v"},
									{"w","v"}	
								};
	
	static Map<String, ArrayList<String>> adjeceList;
	
	public static Map<String, ArrayList<String>> buildAdecentList (String [][] edges) {
		Map <String, ArrayList<String>> adMap = new HashMap<>();
		for (String[] vertex: edges) {
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
	
	
	public static int shortestPath(Map<String, ArrayList<String>> graph, String src, String dst) {
		int count = 0;
		int min = graph.size();
		Queue<String> queu = new PriorityQueue<String>();
		Map <String, Integer> qMap = new HashMap<String, Integer>();
		Set<String> visted = new HashSet<String>();
		queu.add(src);
		qMap.put(src, 0);
		while(queu.size() > 0)
		{
			String obj = queu.poll();
			Integer distance = qMap.get(obj);
			qMap.remove(obj);
			if(obj == dst) return (Integer) distance;
			
			for(String neighbor: graph.get(obj)) {
				if(!visted.contains(neighbor)) {
					queu.add(neighbor);
					qMap.put(neighbor, distance +1 );
					visted.add(neighbor);
				}
				
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		adjeceList = ShortestPath.buildAdecentList(edges);
		adjeceList.forEach((index, elem)->{
			System.out.println(index + ":" + elem);
		});
		System.out.println("Shortest path has "+ShortestPath.shortestPath(adjeceList, "v","b")+" routes");
	}

}
