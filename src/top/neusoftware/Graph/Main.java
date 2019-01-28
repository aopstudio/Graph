package top.neusoftware.Graph;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		int[][] m=new int[3][3];
		m[0][1]=1;
		m[1][0]=1;
		m[1][2]=1;
		m[2][1]=1;
		//String graph=GenerateGraph.generateFromMatrix(m);
		ListGraph lg=new ListGraph(m);
		lg.print();
		String graph=GenerateGraph.generateFromList(lg);
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
