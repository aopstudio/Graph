package top.neusoftware.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入城市数量和路径数量");
		int cityNum=sc.nextInt(),pathNum=sc.nextInt();
		System.out.println("请输入所有城市名，以空格隔开");
		String[] nodes=new String[cityNum];
		for(int i=0;i<cityNum;i++) {
			nodes[i]=sc.next();
		}
		//String[] nodes= {"北京","上海","台北","泰州","宁波"};
		int[][] m=new int[nodes.length][nodes.length];
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				if(j==i) {
					m[i][j]=0;
				}
				else {
					m[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		System.out.println("请输入所有路径信息，格式：起始城市编号 目的地城市编号 路径长度");
		
		m[0][1]=1213;
		m[1][4]=200;
		m[1][2]=900;
		m[4][2]=600;
		m[0][3]=1200;
		m[3][4]=400;
		MatrixGraph mg=new MatrixGraph(m,nodes);
		String graph=mg.generateDG();
		int[][] shortest=mg.shortestPath(0);
		String shortestPath=mg.printShortestPath(0, 4);
		for(int i=0;i<nodes.length;i++) {
			System.out.print(shortest[0][i]+"\t");
		}
		System.out.println();
		for(int i=0;i<nodes.length;i++) {
			System.out.print(shortest[1][i]+"\t");
		}
		System.out.println();
		/*
		ListGraph lg=new ListGraph(m,nodes);
		int[][] shortest=lg.shortestPath(0);
		String shortestPath=lg.printShortestPath(0, 2);
		lg.print();
		String graph=lg.generateDG();
		System.out.print(graph);*/
		String html1=GenerateHTML.Generate(graph);
		String html2=GenerateHTML.Generate(shortestPath);
		try {
			WriteFile.write(html1);
			WriteFile.writeShortest(html2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
