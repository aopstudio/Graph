package top.neusoftware.Graph;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String[] nodes= {"北京","上海","台湾","泰州","宁波"};
		int[][] m=new int[nodes.length][nodes.length];
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m[i][j]=Integer.MAX_VALUE;
			}
		}
		m[0][1]=1213;
		m[1][2]=700;
		m[0][3]=1200;
		m[3][4]=200;
		MatrixGraph mg=new MatrixGraph(m,nodes);
		//String graph=GenerateGraph.generateFromMatrix(m);
		ListGraph lg=new ListGraph(m,nodes);
		lg.print();
		String graph=mg.generateDG();
		String html=GenerateHTML.Generate(graph);
		System.out.print(graph);
		try {
			WriteFile.write(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
