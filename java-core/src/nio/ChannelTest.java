package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * practice of nio channel
 * @author ray.sun
 *
 */
public class ChannelTest {
	
	@Test
	public void test3() throws IOException{
		RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		
		fromChannel.transferTo(position, count, toChannel);
		
		fromFile.close();
		toFile.close();
	}
	
	@Test
	public void test2() throws IOException{
		RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
		FileChannel fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
		FileChannel toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);
		
		fromFile.close();
		toFile.close();
	}
	
	@Test
	public void test1() throws IOException{
		RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(48);	// create buffer with capacity of 48 bytes
		int bytesRead = inChannel.read(buf);	//read data into buffer from channel
		while(bytesRead != -1){
			System.out.println("Read" + bytesRead);
			buf.flip();	// make buffer ready for read out
			
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
}
