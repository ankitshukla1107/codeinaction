package self.preparation.graph;

//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
class GraphTraversal {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	GraphTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void bfs(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	private void dfs(int source) {
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		visited[source] = true;
		stack.push(source);
		while (stack.size() != 0) {
			int item = stack.pop();
			System.out.println(item);
			Iterator<Integer> i = adj[item].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {
		GraphTraversal g = new GraphTraversal(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "
				+ "(starting from vertex 2)");

		g.bfs(2);

		System.out.println("Following is Depth First Traversal "
				+ "(starting from vertex 2)");

		g.dfs(2);
	}
}
