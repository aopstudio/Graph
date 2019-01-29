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
    		v.data= i+"";	//设置结点数据为结点的编号
    		for(int j=0;j<size;j++) {
    			if(m[i][j]!=0) {	//j和i相邻
    				if(v.firstEdge==null) {		//如果i没有边
    					v.firstEdge=new ENode();	//添加i的新边
    					v.firstEdge.ivex=j;
    					v.firstEdge.degree=m[i][j];
    				}
    				else {		//i已经有边
    					ENode e=v.firstEdge;	
    					while(e.nextEdge!=null) {
    						e=e.nextEdge;	//找到最后那条边
    					}
    					e.nextEdge=new ENode();		//在最后添加上新边
    					e.nextEdge.ivex=j;
    					e.nextEdge.degree=m[i][j];
    				}
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
    		v.data= vertexes[i];	//设置结点数据为结点的编号
    		for(int j=0;j<size;j++) {
    			if(edges[i][j]!=0) {	//j和i相邻
    				if(v.firstEdge==null) {		//如果i没有边
    					v.firstEdge=new ENode();	//添加i的新边
    					v.firstEdge.ivex=j;
    					v.firstEdge.degree=edges[i][j];
    				}
    				else {		//i已经有边
    					ENode e=v.firstEdge;	
    					while(e.nextEdge!=null) {
    						e=e.nextEdge;	//找到最后那条边
    					}
    					e.nextEdge=new ENode();		//在最后添加上新边
    					e.nextEdge.ivex=j;
    					e.nextEdge.degree=edges[i][j];
    				}
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
    		v.data= vertexes[i];	//设置结点数据为结点的编号
    		for(int j=0;j<size;j++) {
    			if(edges[i][j]!=0) {	//j和i相邻
    				if(v.firstEdge==null) {		//如果i没有边
    					v.firstEdge=new ENode();	//添加i的新边
    					v.firstEdge.ivex=j;
    					v.firstEdge.degree=edges[i][j];
    				}
    				else {		//i已经有边
    					ENode e=v.firstEdge;	
    					while(e.nextEdge!=null) {
    						e=e.nextEdge;	//找到最后那条边
    					}
    					e.nextEdge=new ENode();		//在最后添加上新边
    					e.nextEdge.ivex=j;
    					e.nextEdge.degree=edges[i][j];
    				}
    			}
    		}
    	}
    }
    public VNode[] getGraph() {
    	return mVexs;
    }
    public void print() {
    	int size=mVexs.length;
    	for(int i=0;i<size;i++) {
    		System.out.print(mVexs[i].data);
    		ENode edge=mVexs[i].firstEdge;
    		while(edge!=null) {
    			System.out.print("\t"+mVexs[edge.ivex].data);
    			edge=edge.nextEdge;
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
}
