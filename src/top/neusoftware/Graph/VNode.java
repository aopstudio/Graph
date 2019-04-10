package top.neusoftware.Graph;

public class VNode {
	private String data;          // 顶点信息
    private ENode firstEdge;    // 指向第一条依附该顶点的弧
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ENode getFirstEdge() {
		return firstEdge;
	}
	public void setFirstEdge(ENode firstEdge) {
		this.firstEdge = firstEdge;
	}
    
}
