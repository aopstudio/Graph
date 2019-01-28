package top.neusoftware.Graph;
//�ڽӱ��ʾ��ͼ
public class ListGraph {

    private VNode[] mVexs;  // ��������
    private int[][] matrix;
    public ListGraph(int[][] m) {
    	int size=m.length;
    	matrix=m;
    	ENode edge;		//������Ǻ���ӵı�
    	mVexs=new VNode[size];
    	for(int i=0;i<size;i++) {
    		VNode v=new VNode();	//�½����
    		mVexs[i]=v;		//�����������б�
    		v.data= i;	//���ý������Ϊ���ı��
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
