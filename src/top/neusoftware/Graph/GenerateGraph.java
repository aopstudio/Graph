package top.neusoftware.Graph;

import java.util.ArrayList;


public class GenerateGraph {
	public static String generateFromMatrix(int[][] m) {	//从邻接矩阵产生图
		int size=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if(m[i][j]!=0) {	//两者相邻
					graph.append(i+"--"+j+";");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateFromList(ListGraph lg) {	//从邻接表产生图
		VNode[] m=lg.getGraph();
		ENode edge;		//读取出边的信息存于此变量
		VNode vertex;	//读取出结点的信息存于此变量
		int size=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {
			vertex=m[i];
			edge=vertex.firstEdge;
			while(edge!=null) {
				int j=edge.ivex;
				if(j>=i) {
					graph.append(i+"--"+edge.ivex+";");
				}
				edge=edge.nextEdge;
			}
		}
		graph.append("}");
		return graph.toString();
	}
}
