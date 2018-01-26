package text_file;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedIOTest {
	
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(
				new BufferedOutputStream(new FileOutputStream("浪淘沙-深圳客")));
		out.write("浪淘沙-深圳客");
		out.write("\n");
		out.write("小叶黄，春风凉。\n"
				+ "脚步匆匆，车声忙。\n"
				+ "又是一年新腊至，身在他乡望故乡。\n"
				+ "老少一堂欢声沸，大雁南飞却也忙。");
		out.write("--屹石三");
		out.close();
	}
	
}
