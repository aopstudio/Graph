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
}
