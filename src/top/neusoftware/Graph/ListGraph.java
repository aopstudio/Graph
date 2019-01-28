package top.neusoftware.Graph;
//邻接表表示的图
public class ListGraph {

    private VNode[] mVexs;  // 顶点数组
    private int[][] matrix;
    public ListGraph(int[][] m) {
    	int size=m.length;
    	matrix=m;
    	ENode edge;		//用作标记和添加的边
    	mVexs=new VNode[size];
    	for(int i=0;i<size;i++) {
    		VNode v=new VNode();	//新建结点
    		mVexs[i]=v;		//将结点插入结点列表
    		v.data= i;	//设置结点数据为结点的编号
    		for(int j=0;j<size;j++) {
    			if(m[i][j]!=0) {
    				if(v.firstEdge==null) {
    					v.firstEdge=new ENode();
    					v.firstEdge.ivex=j;
    				}
    				else {
    					ENode e=v.firstEdge;
    					while(e.nextEdge!=null) {
    						e=e.nextEdge;
    					}
    					e.nextEdge=new ENode();
    					e.nextEdge.ivex=j;
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
    			System.out.print("\t"+edge.ivex);
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
