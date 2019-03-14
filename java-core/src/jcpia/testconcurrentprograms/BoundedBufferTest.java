package jcpia.testconcurrentprograms;

import org.junit.Assert;

import java.util.concurrent.Semaphore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class BoundedBufferTest {

    public static void main(String[] args) throws InterruptedException {
        testIsEmptyWhenConstructed();
        testIsFullAfterPuts();
        testTakeBlockWhenEmpty();
    }

    private final static long LOCKUP_DETECT_TIMEOUT = 1000;

    static void testTakeBlockWhenEmpty(){
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(){
            @Override
            public void run() {
                try{
//                    System.out.println("do take");
                    int unused = bb.take();
                    fail();
                }catch (InterruptedException success){
//                    System.out.println("Take-Block test success");
                }

            }
        };

        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
//            System.out.println("do interrupt");
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        }catch (Exception unexpected){
            fail();
        }
    }

    static void testIsEmptyWhenConstructed(){
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Assert.assertTrue(bb.isEmpty());
        Assert.assertFalse(bb.isFull());
    }

    static void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i=0; i<10; i++)
            bb.put(i);
        Assert.assertTrue(bb.isFull());
        Assert.assertFalse(bb.isEmpty());
    }

}