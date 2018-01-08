package self.preparation.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph1 {

	private int vertexCount;
	private LinkedList<Integer> adjListArray[];

	public Graph1(int vertexCount) {
		this.vertexCount = vertexCount;
		adjListArray = new LinkedList[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(int src, int dest) {
		adjListArray[src].addFirst(dest);
		adjListArray[dest].addFirst(src);
	}

	private void printGraph() {
		for (int i = 0; i < vertexCount; i++) {
			System.out.println("Adjacency List of vertex " + i + " is: ");
			for (Integer element : adjListArray[i]) {
				System.out.printf("-> " + element);
			}
			System.out.println();
		}
	}

	private void bfs(int source) {
		boolean visited[] = new boolean[vertexCount];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[source] = true;
		queue.add(source);

		while (queue.size() != 0) {
			int item = queue.poll();
			System.out.println(item);
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adjListArray[source].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	private void dfs(int source){
		boolean visited[] = new boolean[vertexCount];
		Stack<Integer> stack = new Stack<Integer>();
		visited[source] = true;
		stack.push(source);
		while(stack.size()!=0){
			int item = stack.pop();
			System.out.println(item);
			Iterator<Integer> i = adjListArray[item].iterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					stack.push(n);
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		Graph1 g = new Graph1(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "
				+ "(starting from vertex 2)");

		//g.bfs(2);
		g.dfs(2);

		// g.printGraph();
	}

}
