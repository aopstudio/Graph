package top.neusoftware.Graph;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		int[][] m=new int[3][3];
		m[0][1]=1213;
		m[1][2]=700;
		String[] nodes= {"北京","上海","台湾"};
		MatrixGraph mg=new MatrixGraph(m,nodes);
		//String graph=GenerateGraph.generateFromMatrix(m);
		ListGraph lg=new ListGraph(m,nodes);
		lg.print();
		String graph=GenerateGraph.generateDGFromMatrix(mg);
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
