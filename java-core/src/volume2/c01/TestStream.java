package volume2.c01;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import org.junit.Test;

public class TestStream {
	
	@Test
	public void test1(){
		try {
			FileInputStream fin = new FileInputStream(Constant.BASE_DIR + "employee.dat");
			
			DataInputStream din = new DataInputStream(fin);
			System.out.println(din.readLong());
			din.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		InputStreamReader in = new InputStreamReader(System.in);
		char[] buf = new char[1024];
		try {
			in.read(buf);
			System.out.println(new String(buf));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	@Test
	public void test3(){
		try {
			PrintWriter out = new PrintWriter(Constant.BASE_DIR + "test3.txt");
			out.println("以下语句由PrintWriter输出：");
			out.println(new Date());
			out.println("今天天气不错，");
			out.println("那又怎么样呢，");
			out.println("阳光明媚啊");
			out.println("哈哈，我的心情还是一样的好");
			out.write(65);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("----test3 done----");
	}
	
}
