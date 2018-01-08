package self.preparation.graph;

public class Graph {

	private int vertexCount;
	private boolean adjMatrix[][];

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}

	public void addEdge(int i, int j) {
		if ((i > 0 && i < vertexCount) && (j > 0 && j < vertexCount)) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}
	}

	public void removeEdge(int i, int j) {
		if ((i > 0 && i < vertexCount) && (j > 0 && j < vertexCount)) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}

	
	public boolean isEdge(int i, int j){
		if((i>0 && i<vertexCount) && (j>0 && j<vertexCount)){
			return adjMatrix[i][j];
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		Graph graph = new Graph(4);
	}

}
