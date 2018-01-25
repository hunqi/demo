package volume2.c01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestByteStream {
	
	@Test
	public void testInt() throws IOException {
		String destinationPath = Constant.BASE_DIR + "byte-stream-01.dat";
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream(destinationPath))){
			out.writeInt(16);
			out.writeInt(15);
			out.writeInt(14);
			out.writeInt(1024);
		}
		
		try(DataInputStream in = new DataInputStream(new FileInputStream(destinationPath))){
			int available = in.available();
			for(int i=0; i<available/4; i++)
				System.out.println(in.readInt());
		}
	}
	
	@Test
	public void testChars() throws IOException {
		String destinationPath = Constant.BASE_DIR + "string-to-byte-01.dat";
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream(destinationPath))){
			out.writeChars("推荐书目：\r\n");
			out.writeChars("金刚婆若菠萝蜜aa\r\n");
			out.writeChars("闲情偶记\r\n");
			out.writeChars("钢铁是怎样炼成的\r\n");
		}
		
		try(DataInputStream in = new DataInputStream(new FileInputStream(destinationPath))){
			int available = in.available();
			for(int i=0; i<available/2; i++)
				System.out.print(in.readChar());
		}
	}
	
}
