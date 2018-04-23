package jvm;

import org.junit.Test;

/**
 * 
 * @author ray.sun
 *
 */
public class GCTest {

	private static final int _1MB = 1024 * 1024;
	
	/**
		VM参数:-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
	 */
	@SuppressWarnings("unused")
	@Test
	public void testHandlePromotion(){
			byte[]allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
			allocation1=new byte[2*_1MB];
			allocation2=new byte[2*_1MB];
			allocation3=new byte[2*_1MB];
			allocation1=null;
			allocation4=new byte[2*_1MB];
			allocation5=new byte[2*_1MB];
			allocation6=new byte[2*_1MB];
			allocation4=null;
			allocation5=null;
			allocation6=null;
			allocation7=new byte[2*_1MB];
	}

	/**
	 * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
	 * -XX:+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	@Test
	public void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		// allocation1+allocation2大于survivo空间一半
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}

	/**
	 * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution
	 */
	@SuppressWarnings("unused")
	@Test
	public void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		// 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}

	/**
	 * -verbose:gc-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 */
	@SuppressWarnings("unused")
	@Test
	public void testPretenureThreShold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}

	/**
	 * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	 * -XX:SurvivorRatio=8
	 */
	@SuppressWarnings("unused")
	@Test
	public static void testAllocation() {
		byte[] allocation1 = new byte[2 * _1MB];
		byte[] allocation2 = new byte[2 * _1MB];
		byte[] allocation3 = new byte[2 * _1MB];
		byte[] allocation4 = new byte[4 * _1MB];// 出现一次Minor GC
	}

}
