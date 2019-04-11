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
				if(edges[i][j]!=Integer.MAX_VALUE&&edges[i][j]!=0) {	//两者相邻
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
				if(edges[i][j]!=Integer.MAX_VALUE&&edges[i][j]!=0) {	//两者相邻
					graph.append(i+"->"+j+"[label=\""+edges[i][j]+"\"];");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public int[][] shortestPath(int start) {	//使用迪杰斯特拉算法得到最短路径，返回两个一维数组，prev代表前驱结点，dist代表最短路径
		int[] prev=new int[vertexes.length];	//最短路径上的前驱结点
		int[] dist=new int[vertexes.length];	//最短路径的长度
		// flag[i]=true表示"顶点start"到"顶点i"的最短路径已成功获取
	    boolean[] flag = new boolean[vertexes.length];
	    // 初始化
	    for (int i = 0; i < vertexes.length; i++) {
	        flag[i] = false;          // 顶点i的最短路径还没获取到
	        prev[i] = start;		//设置临时前驱结点为start
	        dist[i] = edges[start][i];  // 顶点i的最短路径为"顶点start"到"顶点i"的权
	    }
	    // 对"顶点start"自身进行初始化
	    flag[start] = true;
	    // 遍历mVexs.length-1次；每次找出一个顶点的最短路径
	    int k=0;
	    for (int i = 1; i < vertexes.length; i++) {
	        // 寻找当前最小的路径；
	        // 即，在未获取最短路径的顶点中，找到离start最近的顶点(k)。
	        int min = Integer.MAX_VALUE;
	        for (int j = 0; j < vertexes.length; j++) {
	            if (flag[j]==false && dist[j]<min) {
	                min = dist[j];
	                k = j;
	            }
	        }
	        // 标记"顶点k"为已经获取到最短路径
	        flag[k] = true;
	        // 修正当前最短路径和前驱顶点
	        // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
	        for (int j = 0; j < vertexes.length; j++) {
	            int tmp = (edges[k][j]==Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + edges[k][j]));
	            if (flag[j]==false && (tmp<dist[j]) ) {
	                dist[j] = tmp;
	                prev[j] = k;
	            }
	        }
	    }
	    int[][] shortest=new int[2][vertexes.length];
	    shortest[0]=prev;
	    shortest[1]=dist;
	    return shortest;
	}
	public String printShortestPath(int start,int terminate) {	//得到表示出最短路径的dot语言代码
		int[][] shortest=shortestPath(start);
		int[] prev=shortest[0];
		int[] dist=shortest[1];
		int size=edges.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		graph.append("dist[label=\"最短距离为"+dist[terminate]+"\" shape=\"plain\"];");
		
	    int l=terminate;
	    while(l!=start) {	//从后往前添加边信息
	    	graph.append(l+"[label=\""+vertexes[l]+"\"];");
	    	graph.append(prev[l]+"->"+l+"[label=\""+edges[prev[l]][l]+"\"];");
	    	l=prev[l];
	    }
	    graph.append(l+"[label=\""+vertexes[l]+"\"];");
	    graph.append("}");
	    return graph.toString();
	}
}
