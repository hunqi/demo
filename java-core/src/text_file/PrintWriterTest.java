package text_file;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class PrintWriterTest {
	
	@Test
	public void run() throws IOException{
		test1();
		test2();
	}
	
	private void test1() throws IOException{
		PrintWriter out = new PrintWriter("employee.txt");
		String content = "春生夏长秋收冬藏";
		out.write(content);		
		out.close();
	}
	
	private void test2(){
		PrintWriter out = new PrintWriter(System.out);
		String content = "春生夏长秋收冬藏";
		out.print(content);
		out.close();
	}
	
}
