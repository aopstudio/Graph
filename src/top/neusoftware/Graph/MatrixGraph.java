package top.neusoftware.Graph;
//用邻接矩阵表示的图
public class MatrixGraph {
	private int[][] edges;	//存放边的信息
	private String[] vertexes;	//存放结点的信息
	public MatrixGraph(int[][] edges, String[] vertexes) {
		super();
		this.edges = edges;
		this.vertexes = vertexes;
	}
	public int[][] getEdges() {
		return edges;
	}
	public String[] getVertexes() {
		return vertexes;
	}
	
}
