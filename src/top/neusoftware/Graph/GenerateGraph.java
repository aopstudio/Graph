package top.neusoftware.Graph;



public class GenerateGraph {
	public static String generateUGFromMatrix(MatrixGraph mg) {	//从邻接矩阵产生无向图
		int[][] edges=mg.getEdges();
		String[] vertexes=mg.getVertexes();
		int size=edges.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {	//读取顶点的信息
			graph.append(i+"[label=\""+vertexes[i]+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			for(int j=i;j<size;j++) {
				if(edges[i][j]!=0) {	//两者相邻
					graph.append(i+"--"+j+"[label=\""+edges[i][j]+"\"];");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateUGFromList(ListGraph lg) {	//从邻接表产生无向图
		VNode[] m=lg.getGraph();
		ENode edge;		//读取出边的信息存于此变量
		VNode vertex;	//读取出结点的信息存于此变量
		int size=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {	//读取顶点信息
			graph.append(i+"[label=\""+m[i].data+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			vertex=m[i];
			edge=vertex.firstEdge;
			while(edge!=null) {
				int j=edge.ivex;
				if(j>=i) {
					graph.append(i+"--"+edge.ivex+"[label=\""+edge.degree+"\"]"+";");
				}
				edge=edge.nextEdge;
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateDGFromMatrix(MatrixGraph mg) {	//从邻接矩阵产生有向图
		int[][] edges=mg.getEdges();
		String[] vertexes=mg.getVertexes();
		int size=edges.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		for(int i=0;i<size;i++) {	//读取顶点的信息
			graph.append(i+"[label=\""+vertexes[i]+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			for(int j=0;j<size;j++) {
				if(edges[i][j]!=0) {	//两者相邻
					graph.append(i+"->"+j+"[label=\""+edges[i][j]+"\"];");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateDGFromList(ListGraph lg) {	//从邻接表产生有向图
		VNode[] m=lg.getGraph();
		ENode edge;		//读取出边的信息存于此变量
		VNode vertex;	//读取出结点的信息存于此变量
		int size=m.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		for(int i=0;i<size;i++) {	//读取顶点信息
			graph.append(i+"[label=\""+m[i].data+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			vertex=m[i];
			edge=vertex.firstEdge;
			while(edge!=null) {
				graph.append(i+"->"+edge.ivex+"[label=\""+edge.degree+"\"]"+";");
				edge=edge.nextEdge;
			}
		}
		graph.append("}");
		return graph.toString();
	}
}
