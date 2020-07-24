package designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonDemo {

    @Test
    public void testRuntimeIsSingleton(){
        Runtime rt1 = Runtime.getRuntime();
        rt1.gc();
        System.out.println(rt1);

        Runtime rt2 = Runtime.getRuntime();
        System.out.println(rt2);

        Assert.assertTrue("rt1 should equal with rt2", rt1 == rt2);
    }

}
