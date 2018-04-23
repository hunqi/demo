package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * demonstrate heap out of memory
 * VM Args:-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * @author ray.sun
 *
 */
public class HeapOOM {

	static class OOMObject{}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
	
}
