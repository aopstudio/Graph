package top.neusoftware.Graph;

import java.util.ArrayList;

public class GenerateGraph {
	public static String generateFromMatrix(int[][] m) {	//���ڽӾ������ͼ
		int a=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<a;i++) {
			for(int j=i;j<a;j++) {
				if(m[i][j]!=0) {	//��������
					graph.append(i+"--"+j+";");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateFromList(ArrayList l) {	//���ڽӱ����ͼ
		
	}
}
