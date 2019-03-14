package jcpia.testconcurrentprograms;

import org.junit.Assert;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExpansionTest {

    public static void main(String[] args) throws InterruptedException {
        int MAX_SIZE = 10;
        TestingThreadFactory threadFactory = new TestingThreadFactory();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_SIZE, threadFactory);

        for (int i=0; i < 10 * MAX_SIZE; i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        for (int i=0; i<20 && threadFactory.numCreated.get() < MAX_SIZE; i++)
            Thread.sleep(100);

        Assert.assertEquals(threadFactory.numCreated.get(), MAX_SIZE);
        System.out.println("---test passed---");
        pool.shutdown();
    }

}
