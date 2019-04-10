package top.neusoftware.Graph;


public class ENode {
	private int ivex;       // 该边所指向的顶点的位置
	private int degree;		//该边的度
    private ENode nextEdge; // 指向下一条弧的指针
    public ENode() {	//空的构造方法，主要用于头结点的构造
    	super();
    }
    public ENode(int ivex, int degree) {	//因为常常在构造时并不知道下一条弧，所以不把它作为构造方法的参数
		this.ivex=ivex;
		this.degree=degree;
	}
	public int getIvex() {
		return ivex;
	}
	public int getDegree() {
		return degree;
	}
	public ENode getNextEdge() {
		return nextEdge;
	}
	public void setNextEdge(ENode nextEdge) {
		this.nextEdge = nextEdge;
	}
	public void setIvex(int ivex) {
		this.ivex = ivex;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
    
}
