package top.neusoftware.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class WriteFile {
	public static void write(String html) throws IOException {
		File file =new File("D:/graph.html");
		if(!file.exists()){
			file.createNewFile();
		}
		PrintStream printStream = null ;
		try {
            printStream= new PrintStream(new FileOutputStream(file));//·��Ĭ������Ŀ��Ŀ¼��
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } 

		printStream.println(html); 
		printStream.close();
	    System.out.println("Done");
	}
}
