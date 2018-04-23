package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.Future;

import org.junit.Test;

public class AsynchronousFileChannelTest {

	@Test
	public void writeByCompletionHandler() throws IOException{
		Path path = Paths.get("files", "test-write.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;
		buffer.put(("浪淘沙-深圳客\n小叶黄，春风凉。\n脚步匆匆，车流忙。\n又是一年新腊至，身在他乡望故乡。\n" + new Date()).getBytes());
		buffer.flip();

		channel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>(){

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				attachment.clear();
				System.out.println("bytes written: " + result);
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				attachment.clear();
			}
			
		});
		buffer.clear();
		channel.close();
	}
	
	@Test
	public void write() throws IOException {
		Path path = Paths.get("files", "test-write.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;
		buffer.put(("浪淘沙-深圳客\n小叶黄，春风凉。\n脚步匆匆，车流忙。\n又是一年新腊至，身在他乡望故乡。\n" + new Date()).getBytes());
		buffer.flip();

		Future<Integer> operation = channel.write(buffer, position);
		buffer.clear();
		
		while(!operation.isDone());
		System.out.println("Write done");
	}

	@Test
	public void readByCompletionHandler() throws IOException {
		Path path = Paths.get("test.txt");
		AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;

		channel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				System.out.println("result = " + result);

				attachment.flip();
				byte[] data = new byte[attachment.limit()];
				attachment.get(data);
				System.out.println(new String(data));
				attachment.clear();

			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				// TODO Auto-generated method stub

			}

		});

		channel.close();
	}

	@Test
	public void test1() throws IOException {
		Path path = Paths.get("test.txt");
		AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 0;

		Future<Integer> operation = channel.read(buffer, position);
		while (!operation.isDone())
			;

		buffer.flip();
		byte[] data = new byte[buffer.limit()];
		buffer.get(data);
		System.out.println(new String(data));
		buffer.clear();
		channel.close();
	}

}
