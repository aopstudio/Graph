package top.neusoftware.Graph;

import java.util.ArrayList;


public class GenerateGraph {
	public static String generateFromMatrix(int[][] m) {	//���ڽӾ������ͼ
		int size=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if(m[i][j]!=0) {	//��������
					graph.append(i+"--"+j+";");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateFromList(ListGraph lg) {	//���ڽӱ����ͼ
		VNode[] m=lg.getGraph();
		ENode edge;		//��ȡ���ߵ���Ϣ���ڴ˱���
		VNode vertex;	//��ȡ��������Ϣ���ڴ˱���
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
