package volume2.c01;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestCharset {
	
	@Test
	public void test1(){
		Charset cset = Charset.forName("ISO-8859-1");
		Set<String> aliases = cset.aliases();
		for(String aliase : aliases)
			System.out.println(aliase);
	}
	
	@Test
	public void test2(){
		Map<String, Charset> charsets = Charset.availableCharsets();
		for(String name : charsets.keySet())
			System.out.println(name);
	}
}
