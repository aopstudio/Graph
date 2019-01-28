package top.neusoftware.Graph;

import java.util.ArrayList;

public class GenerateGraph {
	public static String generateFromMatrix(int[][] m) {	//从邻接矩阵产生图
		int a=m.length;
		StringBuilder graph=new StringBuilder("graph g {");
		for(int i=0;i<a;i++) {
			for(int j=i;j<a;j++) {
				if(m[i][j]!=0) {	//两者相邻
					graph.append(i+"--"+j+";");
				}
			}
		}
		graph.append("}");
		return graph.toString();
	}
	public static String generateFromList(ArrayList l) {	//从邻接表产生图
		
	}
}
