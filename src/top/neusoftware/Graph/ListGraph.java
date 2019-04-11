package top.neusoftware.Graph;
//邻接表表示的图
public class ListGraph {

    private VNode[] mVexs;  // 顶点数组
    private int[][] matrix;
    public ListGraph(int[][] m) {
    	int size=m.length;
    	matrix=m;
    	mVexs=new VNode[size];
    	for(int i=0;i<size;i++) {
    		VNode v=new VNode();	//新建结点
    		mVexs[i]=v;		//将结点插入结点列表
    		v.setData(i+"");	//设置结点数据为结点的编号
    		v.setFirstEdge(new ENode());
    		for(int j=0;j<size;j++) {
    			if(m[i][j]!=Integer.MAX_VALUE&&m[i][j]!=0) {	//j和i相邻且不相等
					ENode e=v.getFirstEdge();	
					while(e.getNextEdge()!=null) {
						e=e.getNextEdge();	//找到最后那条边
					}
					e.setNextEdge(new ENode(j,m[i][j]));	//在最后添加上新边		
    			}
    		}
    	}
    }
    
    public ListGraph(int[][] edges,String[] vertexes) {
    	int size=edges.length;
    	mVexs=new VNode[size];
    	for(int i=0;i<size;i++) {
    		VNode v=new VNode();	//新建结点
    		mVexs[i]=v;		//将结点插入结点列表
    		v.setData(vertexes[i]);	//设置结点数据为结点的编号
    		v.setFirstEdge(new ENode());	//头结点，不保存数据，这样就不需要判断v.firstEdge是否为空
    		for(int j=0;j<size;j++) {
    			if(edges[i][j]!=Integer.MAX_VALUE&&edges[i][j]!=0) {	//j和i相邻且不相等
    				ENode e=v.getFirstEdge();
					while(e.getNextEdge()!=null) {
						e=e.getNextEdge();	//找到最后那条边
					}
					e.setNextEdge(new ENode(j,edges[i][j]));		//在最后添加上新边
    			}
    		}
    	}
    }
    
    public ListGraph(MatrixGraph mg) {	//加入顶点信息，并使用邻接矩阵进行的初始化
    	int[][] edges=mg.getEdges();
    	String[] vertexes=mg.getVertexes();
    	int size=edges.length;
    	mVexs=new VNode[size];
    	for(int i=0;i<size;i++) {
    		VNode v=new VNode();	//新建结点
    		mVexs[i]=v;		//将结点插入结点列表
    		v.setData(vertexes[i]);	//设置结点数据为结点的编号
    		v.setFirstEdge(new ENode());	//头结点，不保存数据，这样就不需要判断v.firstEdge是否为空，如下方注释的操作
    		for(int j=0;j<size;j++) {
    			if(edges[i][j]!=Integer.MAX_VALUE&&edges[i][j]!=0) {	//j和i相邻且不相等
    				/*if(v.firstEdge==null) {		//如果i没有边
    					v.firstEdge=new ENode();	//添加i的新边
    					v.firstEdge.ivex=j;
    					v.firstEdge.degree=edges[i][j];
    				}
    				else {		//i已经有边
    					ENode e=v.firstEdge;	
    					while(e.nextEdge!=null) {
    						e=e.nextEdge;	//找到最后那条边
    					}
    					e.nextEdge=new ENode(j,edges[i][j]);		//在最后添加上新边
    				}*/
    				ENode e=v.getFirstEdge();
					while(e.getNextEdge()!=null) {
						e=e.getNextEdge();	//找到最后那条边
					}
					e.setNextEdge(new ENode(j,edges[i][j]));		//在最后添加上新边
    			}
    		}
    	}
    }

    public void print() {
    	int size=mVexs.length;
    	for(int i=0;i<size;i++) {
    		System.out.print(mVexs[i].getData());
    		ENode edge=mVexs[i].getFirstEdge().getNextEdge();
    		while(edge!=null) {
    			System.out.print("\t"+mVexs[edge.getIvex()].getData());
    			edge=edge.getNextEdge();
    		}
    		System.out.println();
    	}
    }
    public void printM() {
    	int size=mVexs.length;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			System.out.print(matrix[i][j]+"\t");
    		}
    		System.out.println();
    	}
    }
    public String generateUG() {	//产生无向图字符串
		ENode edge;		//读取出边的信息存于此变量
		VNode vertex;	//读取出结点的信息存于此变量
		int size=mVexs.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {	//读取顶点信息
			graph.append(i+"[label=\""+mVexs[i].getData()+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			vertex=mVexs[i];
			edge=vertex.getFirstEdge().getNextEdge();	//跳过头结点
			while(edge!=null) {
				int j=edge.getIvex();
				if(j>=i) {
					graph.append(i+"--"+edge.getIvex()+"[label=\""+edge.getDegree()+"\"]"+";");
				}
				edge=edge.getNextEdge();
			}
		}
		graph.append("}");
		return graph.toString();
	}
    public String generateDG() {	//从邻接表产生有向图
		ENode edge;		//读取出边的信息存于此变量
		VNode vertex;	//读取出结点的信息存于此变量
		int size=mVexs.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		for(int i=0;i<size;i++) {	//读取顶点信息
			graph.append(i+"[label=\""+mVexs[i].getData()+"\"];");
		}
		for(int i=0;i<size;i++) {	//读取边的信息
			vertex=mVexs[i];
			edge=vertex.getFirstEdge().getNextEdge();	//跳过头结点
			while(edge!=null) {
				graph.append(i+"->"+edge.getIvex()+"[label=\""+edge.getDegree()+"\"]"+";");
				edge=edge.getNextEdge();
			}
		}
		graph.append("}");
		return graph.toString();
	}
    public int[][] shortestPath(int start) {
    	int[] prev=new int[mVexs.length];	//最短路径上的前驱结点
		int[] dist=new int[mVexs.length];	//最短路径的长度
		boolean[] flag = new boolean[mVexs.length];
    	VNode vertex=mVexs[start];
    	ENode edge=vertex.getFirstEdge().getNextEdge();
	    // 初始化
    	for (int i = 0; i < mVexs.length; i++) {
	        flag[i] = false;     
	        prev[i] = start;		
	        dist[i] = Integer.MAX_VALUE; 
	    }
    	//首先读入与出发点直接邻接的边信息并设置为暂定最短路径
		while(edge!=null) {
			dist[edge.getIvex()]=edge.getDegree();
			edge=edge.getNextEdge();
		}
	    // 对出发点自身进行初始化
	    flag[start] = true;
	    dist[start]=0;
	    // 遍历mVexs.length-1次；每次找出一个顶点的最短路径
	    int k=0;
	    for (int i = 1; i < mVexs.length; i++) {
	    	int min = Integer.MAX_VALUE;
	    	for (int j = 0; j < mVexs.length; j++) {
	            if (flag[j]==false && dist[j]<min) {
	                min = dist[j];
	                k = j;
	            }
	        }
	    	// 标记"顶点k"为已经获取到最短路径
	        flag[k] = true;
	        // 修正当前最短路径和前驱顶点
	        // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的暂定最短路径和前驱顶点"
	        edge=mVexs[k].getFirstEdge().getNextEdge();
	        while(edge!=null) {
	        	int tmp = min + edge.getDegree();	
	        	int j=edge.getIvex();	//邻接的结点编号
	        	if (flag[j]==false && (tmp<dist[j]) ) {	
	                dist[j] = tmp;
	                prev[j] = k;
	            }
	        	edge=edge.getNextEdge();
			}
	    }
	    int[][] shortest=new int[2][mVexs.length];
	    shortest[0]=prev;
	    shortest[1]=dist;
	    return shortest;
    }
    public String printShortestPath(int start,int terminate) {	//得到表示出最短路径的dot语言代码
		int[][] shortest=shortestPath(start);
		int[] prev=shortest[0];
		int[] dist=shortest[1];
		int size=mVexs.length;
		StringBuilder graph=new StringBuilder("digraph g {");
		graph.append("dist[label=\"最短距离为"+dist[terminate]+"\" shape=\"plain\"];");
		
	    int l=terminate;
	    while(l!=start) {	//从后往前添加边信息
	    	int degree=Integer.MAX_VALUE;	//存放边的长度
	    	ENode edge=mVexs[prev[l]].getFirstEdge().getNextEdge();
	    	while(edge!=null) {
	    		if(edge.getIvex()==l) {	//找到了该边经过的结点
	    			degree=edge.getDegree();	//设置该边的度
	    		}
	    		edge=edge.getNextEdge();
	    	}
	    	graph.append(l+"[label=\""+mVexs[l].getData()+"\"];");
	    	graph.append(prev[l]+"->"+l+"[label=\""+degree+"\"];");
	    	l=prev[l];
	    }
	    graph.append(l+"[label=\""+mVexs[l].getData()+"\"];");
	    graph.append("}");
	    return graph.toString();
	}
}
