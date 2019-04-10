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
	public String generateUG() {	//产生无向图字符串
		int size=edges.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {	//读取顶点的信息
			graph.append(i+"[label=\""+vertexes[i]+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			for(int j=i;j<size;j++) {
				if(edges[i][j]!=Integer.MAX_VALUE) {	//两者相邻
					graph.append(i+"--"+j+"[label=\""+edges[i][j]+"\"];");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public String generateDG() {	//产生有向图字符串
		int size=edges.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		for(int i=0;i<size;i++) {	//读取顶点的信息
			graph.append(i+"[label=\""+vertexes[i]+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			for(int j=0;j<size;j++) {
				if(edges[i][j]!=Integer.MAX_VALUE) {	//两者相邻
					graph.append(i+"->"+j+"[label=\""+edges[i][j]+"\"];");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
}
