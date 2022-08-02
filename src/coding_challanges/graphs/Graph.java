package coding_challanges.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// Class to store the edges of the weighted graph
class Edge {
	int src, dest, weight;
	Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

public class Graph {
//	node of the adjacency list
	static class Node {
		int value, weight;
		Node(int value, int weiht) {
			this.value = value;
			this.weight = weiht;
		}
	}
	
//	define adjacency list
	static List<List<Node>> adjList = new ArrayList<>();
	int vertices;
	static boolean[] visited;
	public Graph(List<Edge> edges) {
		vertices = edges.size();
		visited = new boolean[vertices];
		for(int i =0; i < edges.size();i++) {
			adjList.add(i, new ArrayList<>());
		}
		
		for (Edge e: edges) {
			adjList.get(e.src).add(new Node(e.dest, e.weight));
		}
	}

//	traverse depth first
	public static void depthFirstTraverseIter(int src) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(src);
		while(stack.size() > 0) {
			int curr = stack.pop();
			visited[curr] = true;
			System.out.print(curr+" ");
			for(Node neighbor : adjList.get(curr)) {
				if(!visited[neighbor.value])
					stack.push(neighbor.value);
			}
		}
		System.out.println();
	}
	
//	traverse breadth first
	public static void bredthFirstTraverseIter(int src) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(src);
		visited = new boolean[adjList.size()];
		while(queue.size() > 0) {
			int curr = queue.poll();
			visited[curr] = true;
			System.out.print(curr+" ");
			for(Node neighbor : adjList.get(curr)) {
				if(!visited[neighbor.value])
					queue.add(neighbor.value);
			}
		}
		System.out.println();
	}
	
//  is there a path from src to dst
	
	public boolean hasPath(int src, int dst) {
		visited = new boolean[adjList.size()];
		Stack<Integer> stack = new Stack<>();
		stack.push(src);
		while(stack.size() > 0) {
			int curr  = stack.pop();
			if(curr == dst) return true;
			visited[curr] = true;
			for(Node neighbor: adjList.get(curr)) {
				if(!visited[neighbor.value])
					stack.push(neighbor.value);
			}
		}
		return false;
	}
	
//	print graph
	public static void printGraph(Graph graph) {
		int srcVetex = 0;
		int listSize = graph.adjList.size();
		
		while(srcVetex < listSize){
			for (Node edge : graph.adjList.get(srcVetex)) {
				System.out.println("Vertex :"+ srcVetex +" --> "+ edge.value +
						" ( "+edge.weight+") \t");
			}
			System.out.println();
			srcVetex++;
		}
	}
}
