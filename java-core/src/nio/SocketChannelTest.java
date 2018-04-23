package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class SocketChannelTest {
	
	@Test
	public void test1() throws IOException{
		SocketChannel channel = SocketChannel.open();
		channel.connect(new InetSocketAddress("http://jenkov.com", 80));
		channel.close();		
	}
	
}
